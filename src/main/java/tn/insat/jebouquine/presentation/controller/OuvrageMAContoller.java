package tn.insat.jebouquine.presentation.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionOuvrage;
import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Categorie;
import tn.insat.jebouquine.data.entity.Editeur;
import tn.insat.jebouquine.data.entity.Ouvrage;
import tn.insat.jebouquine.data.repository.IOuvrageRepository;
import tn.insat.jebouquine.presentation.validator.OuvrageValidator;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Devcartha on 12/11/2015.
 */
@Controller
public class OuvrageMAContoller {
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
                System.out.println(text);
                try {
                    File file = new File("C:\\Users\\Devcartha\\Pictures\\"+text);
                    int length = (int) file.length();
                    BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
                    byte[] bytes = new byte[length];
                    reader.read(bytes, 0, length);
                    reader.close();
                    byte[] encoded = Base64.encodeBase64(bytes);
                    String encodedImage ="data:image/jpeg;base64,"+new String(encoded);
                    setValue(encodedImage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        binder.registerCustomEditor(String.class, "tableDeMatiere", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                System.out.println(text);
                try {
                    File file = new File("C:\\Users\\Devcartha\\Documents\\"+text);
                    String tableDeMatiere="";
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String ligne="";
                    while((ligne=br.readLine())!=null)
                        tableDeMatiere+=ligne+"\n";
                    setValue(tableDeMatiere);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        binder.registerCustomEditor(ArrayList.class, "auteurs", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                ArrayList<Auteur> listAuteurs = new ArrayList<>();
                String[] auteurs = text.split(",");
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
                if ((ArrayList<Auteur>) getValue() != null) {
                    for (Auteur a : (ArrayList<Auteur>) getValue())
                        auteurs += a.getNom() + ",";
                    auteurs = auteurs.substring(0, auteurs.lastIndexOf(","));
                }
                return auteurs;
            }
        });
        binder.registerCustomEditor(ArrayList.class, "categories", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                ArrayList<Categorie> listCategories = new ArrayList<>();
                String[] categories = text.split(",");
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
                if ((ArrayList<Categorie>) getValue() != null) {
                    for (Categorie c : (ArrayList<Categorie>) getValue())
                        categories += c.getTitre() + ",";
                    categories = categories.substring(0, categories.lastIndexOf(","));
                }
                return categories;
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
                if (((Editeur) getValue()) != null)
                    editeur = ((Editeur) getValue()).getNom();
                return editeur;
            }
        });
    }

    @RequestMapping(value = "/ouvrage/form", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvrageForm() {
        ModelAndView mv = new ModelAndView("ouvrage/ouvrageForm");
        mv.addObject("ouvrage", new Ouvrage());
        return mv;
    }

    @RequestMapping(value = "/ouvrage/save", method = RequestMethod.POST)
    public ModelAndView addOuvrage(@ModelAttribute @Validated Ouvrage ouvrage, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("ouvrage/ouvrageForm");
        } else {
            this.gestionOuvrage.addOuvrage(ouvrage);
            return new ModelAndView("redirect:/ouvrage/list");
        }
    }

    @RequestMapping(value = "/ouvrage/list", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvragesList() {
        ModelAndView mv = new ModelAndView("ouvrage/ouvrageList");
        mv.addObject("ouvrages", gestionOuvrage.getAll());
        return mv;
    }

    @RequestMapping(value = "/ouvrage/details", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvrageDetails(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("ouvrage/ouvrageDetails");
        Ouvrage ouvrage = gestionOuvrage.getOuvrageById(id);
        mv.addObject("ouvrage",ouvrage);
        mv.addObject("avis",gestionOuvrage.getAvisClients(ouvrage));
        return mv;
    }

}
