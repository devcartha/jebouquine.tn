package tn.insat.jebouquine.presentation.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionCommande;
import tn.insat.jebouquine.data.entity.Client;
import tn.insat.jebouquine.data.entity.Commande;
import tn.insat.jebouquine.data.entity.LigneCommande;
import tn.insat.jebouquine.data.entity.Panier;

import javax.servlet.http.HttpSession;

/**
 * Created by Devcartha on 12/17/2015.
 */
@Controller
@Scope(value = "session")
public class AchatController {

    @Autowired
    IGestionCommande gestionCommande;

    @RequestMapping(value = "/catalog/panier", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getPanier(HttpSession httpSession) {
        if(httpSession.getAttribute("client")==null){
            return new ModelAndView("redirect:/client/signInForm");
        }
        ModelAndView mv = new ModelAndView("clientView/panier/form");
        mv.addObject("panier", httpSession.getAttribute("panier"));
        return mv;
    }

    @RequestMapping(value = "/catalog/order", method = RequestMethod.POST)
    public ModelAndView order(@ModelAttribute Panier panier, HttpSession httpSession) {
        if(httpSession.getAttribute("client")==null){
            return new ModelAndView("redirect:/client/signInForm");
        }
        panier.setClient((Client) httpSession.getAttribute("client"));
        boolean errors = false;
        String erreurMsg = "La quantité du/des livre(s) suivant(s) : ";
        System.out.println();
        for (LigneCommande lc : panier.getLignesCommande()) {
            if (lc.getOuvrage().getQuantiteDispo() < lc.getQuantite()) {
                erreurMsg += lc.getOuvrage().getTitre() + ", ";
                errors = true;
            }
        }
        erreurMsg += " est insuffisante";
        if (errors) {
            ModelAndView mv = new ModelAndView("clientView/panier/form");
            mv.addObject("panier", httpSession.getAttribute("panier"));
            mv.addObject("errors", errors);
            mv.addObject("erreurMsg", erreurMsg);
            return mv;
        }

        Commande commande = gestionCommande.passerCommande(panier);
        ModelAndView mv = new ModelAndView("clientView/commande/success");
        mv.addObject("commande",commande);
        return mv;
    }


}
