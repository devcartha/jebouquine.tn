package tn.insat.jebouquine.presentation.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionAvi;
import tn.insat.jebouquine.business.facade.IGestionCommande;
import tn.insat.jebouquine.business.facade.IGestionOuvrage;
import tn.insat.jebouquine.data.entity.*;
import tn.insat.jebouquine.data.repository.IAviRepository;

import javax.servlet.http.HttpSession;

/**
 * Created by Devcartha on 12/14/2015.
 */
@Controller
@Scope(value = "session")
public class CatalogController {

    @Autowired
    IGestionOuvrage gestionOuvrage;
    @Autowired
    IGestionAvi gestionAvi;


    @RequestMapping(value = "/catalog/list", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvragesList(HttpSession httpSession) {
        ModelAndView mv = new ModelAndView("clientView/ouvrage/list");
        mv.addObject("ouvrages", gestionOuvrage.getAll());
        return mv;
    }

    @RequestMapping(value = "/catalog/details", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvrageDetails(@RequestParam Long id,HttpSession httpSession) {
        if(httpSession.getAttribute("client")==null){
            return new ModelAndView("redirect:/client/signInForm");
        }
        ModelAndView mv = new ModelAndView("clientView/ouvrage/details");
        Ouvrage ouvrage = gestionOuvrage.getOuvrageById(id);
        mv.addObject("ouvrage",ouvrage);
        mv.addObject("avis",gestionOuvrage.getAvisClients(ouvrage));
        mv.addObject("avi",new Avi());
        return mv;
    }

    @RequestMapping(value = "/catalog/addToCart", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView addOuvrageToCart(@RequestParam Long id, HttpSession httpSession) {
        if(httpSession.getAttribute("client")==null){
            return new ModelAndView("redirect:/client/signInForm");
        }
        Ouvrage ouvrage = gestionOuvrage.getOuvrageById(id);
        LigneCommande lc = new LigneCommande();
        lc.setOuvrage(ouvrage);
        lc.setPrix(ouvrage.getPrix());
        if (!((Panier)httpSession.getAttribute("panier")).getLignesCommande().contains(lc))
        ((Panier)httpSession.getAttribute("panier")).getLignesCommande().add(lc);
        return new ModelAndView("redirect:/catalog/details?id="+id);
    }

    @RequestMapping(value = "/catalog/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView deleteOuvrage(@RequestParam String keyWord,HttpSession httpSession) {
        if(httpSession.getAttribute("client")==null){
            return new ModelAndView("redirect:/client/signInForm");
        }
        ModelAndView mv = new ModelAndView("clientView/ouvrage/list");
        mv.addObject("ouvrages",gestionOuvrage.getOuvrageByKeyWord(keyWord));
        return mv;
    }

    @RequestMapping(value = "/catalog/avi", method = RequestMethod.POST)
    public ModelAndView addAvi(@ModelAttribute Avi avi,@RequestParam Long id, HttpSession httpSession) {
        if(httpSession.getAttribute("client")==null){
            return new ModelAndView("redirect:/client/signInForm");
        }
        ModelAndView mv = new ModelAndView("clientView/ouvrage/details");
        Ouvrage ouvrage = gestionOuvrage.getOuvrageById(id);
        gestionAvi.addAvi(avi,ouvrage,(Client) httpSession.getAttribute("client"));
        mv.addObject("ouvrage",ouvrage);
        mv.addObject("avis",gestionOuvrage.getAvisClients(ouvrage));
        return mv;
    }

}
