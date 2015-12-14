package tn.insat.jebouquine.presentation.controller.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionAuteur;
import tn.insat.jebouquine.data.entity.Auteur;

import javax.validation.Valid;

/**
 * Created by Devcartha on 12/14/2015.
 */
@Controller
public class AuteurController {
    @Autowired
    IGestionAuteur gestionAuteur;

    @RequestMapping(value = "/auteur/formI", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAuteurFormForInsertion() {
        ModelAndView mv = new ModelAndView("administratorView/auteur/form");
        mv.addObject("auteur", new Auteur());
        return mv;
    }

    @RequestMapping(value = "/auteur/formU", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAuteurFormForUpdate(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("administratorView/auteur/form");
        mv.addObject("auteur", gestionAuteur.getAuteurById(id));
        return mv;
    }

    @RequestMapping(value = "/auteur/save", method = RequestMethod.POST)
    public ModelAndView addAuteur(@ModelAttribute @Valid Auteur auteur, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("administratorView/auteur/form");
        } else {
            this.gestionAuteur.addAuteur(auteur);
            return new ModelAndView("redirect:/auteur/list");
        }
    }

    @RequestMapping(value = "/auteur/update", method = RequestMethod.POST)
    public ModelAndView updateAuteur(@ModelAttribute @Valid Auteur auteur, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("administratorView/auteur/form");
        } else {
            this.gestionAuteur.addAuteur(auteur);
            return new ModelAndView("redirect:/auteur/list");
        }
    }


    @RequestMapping(value = "/auteur/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchAuteur(@RequestParam String keyWord) {
        ModelAndView mv = new ModelAndView("administratorView/auteur/list");
        mv.addObject("auteurs",gestionAuteur.getAuteursByKeyWord(keyWord));
        return mv;
    }


    @RequestMapping(value = "/auteur/list", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAuteursList() {
        ModelAndView mv = new ModelAndView("administratorView/auteur/list");
        mv.addObject("auteurs", gestionAuteur.getAll());
        return mv;
    }


    @RequestMapping(value = "/auteur/delete", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView deleteAuteur(@RequestParam Long id) {
        gestionAuteur.deleteAuteur(id);
        return new ModelAndView("redirect:/auteur/list");
    }




}
