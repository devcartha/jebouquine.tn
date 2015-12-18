package tn.insat.jebouquine.presentation.controller.administrator;

import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.collection.internal.PersistentBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionOuvrage;
import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Categorie;
import tn.insat.jebouquine.data.entity.Editeur;
import tn.insat.jebouquine.data.entity.Ouvrage;
import tn.insat.jebouquine.presentation.validator.OuvrageValidator;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Devcartha on 12/11/2015.
 */
@Controller
@Scope(value = "session")
public class OuvrageContoller {
    @Autowired
    IGestionOuvrage gestionOuvrage;
    @Autowired
    OuvrageValidator validator;

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.setValidator(validator);
        binder.registerCustomEditor(String.class, "image", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                try {
                    //Security stops us for knowing anything about the filing system of the client computer
                    File file = new File("C:\\Users\\Devcartha\\Pictures\\"+text);
                    int length = (int) file.length();
                    BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
                    byte[] bytes = new byte[length];
                    reader.read(bytes, 0, length);
                    reader.close();
                    byte[] encoded = Base64.encodeBase64(bytes);
                    String encodedImage =text+"|data:image/jpeg;base64,"+new String(encoded);
                    setValue(encodedImage);
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
            @Override
            /*The file input type creates a field through which users can upload files
             from their local computer or network. The VALUE attribute specifies the name
             of the initial file, but it is typically ignored by browsers as a security precaution.*/
            public String getAsText(){
                String image = "";
                if ( getValue() != null){
                    if (getValue().toString().contains("|")){
                        image = getValue().toString().substring(0,getValue().toString().indexOf("|"));
                    }
                }
                return image;
            }
        });
        binder.registerCustomEditor(String.class, "tableDeMatiere", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                try {
                    File file = new File("C:\\Users\\Devcartha\\Documents\\"+text);
                    String tableDeMatiere="";
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String ligne=text+"|";
                    while((ligne=br.readLine())!=null)
                        tableDeMatiere+=ligne+"\n";
                    setValue(tableDeMatiere);
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
        });
        binder.registerCustomEditor(ArrayList.class, "auteurs", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                ArrayList<Auteur> listAuteurs = new ArrayList<>();
                String[] auteurs = text.split(", ");
                for (String auteur : auteurs) {
                    Auteur a = new Auteur();
                    a.setNom(auteur);
                    listAuteurs.add(a);
                }
                setValue(listAuteurs);
            }

            @Override
            public String getAsText() {
                String auteurs = "";
                if (getValue() != null) {
                    if (getValue().getClass().toString().contains("PersistentBag")){
                        for (Object a : ((PersistentBag) getValue()))
                            auteurs += ((Auteur) a).getNom() + ",";
                    }else{
                        for (Auteur a : (ArrayList<Auteur>) getValue())
                            auteurs += a.getNom() + ",";
                    }
                    if(auteurs.contains(","))
                    return  auteurs.substring(0, auteurs.lastIndexOf(","));
                }
                return  auteurs;
            }
        });
        binder.registerCustomEditor(ArrayList.class, "categories", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                ArrayList<Categorie> listCategories = new ArrayList<>();
                String[] categories = text.split(", ");
                for (String categorie : categories) {
                    Categorie c = new Categorie();
                    c.setTitre(categorie);
                    listCategories.add(c);
                }
                setValue(listCategories);
            }

            @Override
            public String getAsText() {
                String categories = "";
                if (getValue() != null) {
                    if (getValue().getClass().toString().contains("PersistentBag")){
                        for (Object c : ((PersistentBag) getValue()))
                            categories += ((Categorie) c).getTitre() + ",";
                    }else{
                        for (Categorie c : (ArrayList<Categorie>) getValue())
                            categories += c.getTitre() + ",";
                    }
                    if(categories.contains(","))
                    return  categories.substring(0, categories.lastIndexOf(","));
                }
                return  categories;
            }
        });
        binder.registerCustomEditor(Editeur.class, "editeur", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                Editeur e = new Editeur(text);
                setValue(e);
            }

            @Override
            public String getAsText() {
                String editeur = "";
                if ((((Editeur) getValue()).getNom()) != null)
                    editeur = ((Editeur) getValue()).getNom();
                return editeur;
            }
        });
    }

    @RequestMapping(value = "/ouvrage/formI", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvrageFormForInsertion(HttpSession httpSession) {
        if(httpSession.getAttribute("admin")==null){
            return new ModelAndView("redirect:/admin/loginForm");
        }
        ModelAndView mv = new ModelAndView("administratorView/ouvrage/form");
        mv.addObject("ouvrage", new Ouvrage());
        return mv;
    }

    @RequestMapping(value = "/ouvrage/formU", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvrageFormForUpdate(@RequestParam Long id,HttpSession httpSession) {
        if(httpSession.getAttribute("admin")==null){
            return new ModelAndView("redirect:/admin/loginForm");
        }
        ModelAndView mv = new ModelAndView("administratorView/ouvrage/form");
        mv.addObject("ouvrage", gestionOuvrage.getOuvrageById(id));
        return mv;
    }

    @RequestMapping(value = "/ouvrage/save", method = RequestMethod.POST)
    public ModelAndView addOuvrage(@ModelAttribute @Valid Ouvrage ouvrage, BindingResult bindingResult,HttpSession httpSession) {
        if(httpSession.getAttribute("admin")==null){
            return new ModelAndView("redirect:/admin/loginForm");
        }
        if (bindingResult.hasErrors()) {
            return new ModelAndView("administratorView/ouvrage/form");
        } else {
            this.gestionOuvrage.addOuvrage(ouvrage);
            return new ModelAndView("redirect:/ouvrage/list");
        }
    }

    @RequestMapping(value = "/ouvrage/update", method = RequestMethod.POST)
    public ModelAndView updateOuvrage(@ModelAttribute @Valid Ouvrage ouvrage, BindingResult bindingResult,HttpSession httpSession) {
        if(httpSession.getAttribute("admin")==null){
            return new ModelAndView("redirect:/admin/loginForm");
        }
        if (bindingResult.hasErrors()) {
            return new ModelAndView("administratorView/ouvrage/form");
        } else {
            this.gestionOuvrage.addOuvrage(ouvrage);
            return new ModelAndView("redirect:/ouvrage/list");
        }
    }

    @RequestMapping(value = "/ouvrage/list", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvragesList(HttpSession httpSession) {
        if(httpSession.getAttribute("admin")==null){
            return new ModelAndView("redirect:/admin/loginForm");
        }
        ModelAndView mv = new ModelAndView("administratorView/ouvrage/list");
        mv.addObject("ouvrages", gestionOuvrage.getAll());
        return mv;
    }

    @RequestMapping(value = "/ouvrage/details", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvrageDetails(@RequestParam Long id,HttpSession httpSession) {
        if(httpSession.getAttribute("admin")==null){
            return new ModelAndView("redirect:/admin/loginForm");
        }
        ModelAndView mv = new ModelAndView("administratorView/ouvrage/details");
        Ouvrage ouvrage = gestionOuvrage.getOuvrageById(id);
        mv.addObject("ouvrage",ouvrage);
        mv.addObject("avis",gestionOuvrage.getAvisClients(ouvrage));
        return mv;
    }

    @RequestMapping(value = "/ouvrage/delete", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView deleteOuvrage(@RequestParam Long id,HttpSession httpSession) {
        if(httpSession.getAttribute("admin")==null){
            return new ModelAndView("redirect:/admin/loginForm");
        }
        gestionOuvrage.deleteOuvrage(id);
        return new ModelAndView("redirect:/ouvrage/list");
    }

    @RequestMapping(value = "/ouvrage/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView deleteOuvrage(@RequestParam String keyWord,HttpSession httpSession) {
        if(httpSession.getAttribute("admin")==null){
            return new ModelAndView("redirect:/admin/loginForm");
        }
        ModelAndView mv = new ModelAndView("administratorView/ouvrage/list");
        mv.addObject("ouvrages",gestionOuvrage.getOuvrageByKeyWord(keyWord));
        return mv;
    }

}
