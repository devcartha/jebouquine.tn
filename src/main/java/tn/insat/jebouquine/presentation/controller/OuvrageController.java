package tn.insat.jebouquine.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionOuvrage;
import tn.insat.jebouquine.data.entity.Ouvrage;
import tn.insat.jebouquine.data.repository.IOuvrageRepository;
import tn.insat.jebouquine.presentation.model.OuvrageModel;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by Devcartha on 12/10/2015.
 */

@Controller
public class OuvrageController {

    @Autowired
    private IOuvrageRepository ouvrageRepository;

    @Autowired
    IGestionOuvrage gestionOuvrage;

    @RequestMapping(value = "/ouvrageForm", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvrageForm(){
        ModelAndView mv = new ModelAndView("ouvrage/ouvrageForm");
        mv.addObject("ouvrage",new OuvrageModel());
        return mv;
    }

    @RequestMapping(value = "/ajoutOuvrage", method = RequestMethod.POST)
    public ModelAndView ajoutOuvrage(@ModelAttribute OuvrageModel ouvrageModel,HttpSession session) {
        HashMap<String,Object> map = gestionOuvrage.ajoutOuvrage(ouvrageModel);
        if(map.isEmpty())
            return new ModelAndView("redirect:/listeOuvrages");
        ModelAndView mv = new ModelAndView("ouvrage/confirmAjoutOuvrage");
        mv.addObject("map",map);
        session.setAttribute("ouvrage",map.get("ouvrage"));
        return mv;
    }

    @RequestMapping(value = "/ajoutOuvrageACE", method = RequestMethod.POST)
    public ModelAndView ajoutOuvrageACE(HttpSession session) {
        this.gestionOuvrage.ajoutOuvrage((Ouvrage) session.getAttribute("ouvrage"));
        return new ModelAndView("redirect:/listeOuvrages");
    }

}
