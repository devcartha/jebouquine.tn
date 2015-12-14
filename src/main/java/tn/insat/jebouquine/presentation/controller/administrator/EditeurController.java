package tn.insat.jebouquine.presentation.controller.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionEditeur;
import tn.insat.jebouquine.data.entity.Editeur;

import javax.validation.Valid;

/**
 * Created by Devcartha on 12/14/2015.
 */
@Controller
public class EditeurController {
    @Autowired
    IGestionEditeur gestionEditeur;

    @RequestMapping(value = "/editeur/formI", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getEditeurFormForInsertion() {
        ModelAndView mv = new ModelAndView("administratorView/editeur/form");
        mv.addObject("editeur", new Editeur());
        return mv;
    }

    @RequestMapping(value = "/editeur/formU", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getEditeurFormForUpdate(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("administratorView/editeur/form");
        mv.addObject("editeur", gestionEditeur.getEditeurById(id));
        return mv;
    }

    @RequestMapping(value = "/editeur/save", method = RequestMethod.POST)
    public ModelAndView addEditeur(@ModelAttribute @Valid Editeur editeur, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("administratorView/editeur/form");
        } else {
            this.gestionEditeur.addEditeur(editeur);
            return new ModelAndView("redirect:/editeur/list");
        }
    }

    @RequestMapping(value = "/editeur/update", method = RequestMethod.POST)
    public ModelAndView updateEditeur(@ModelAttribute @Valid Editeur editeur, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("administratorView/editeur/form");
        } else {
            this.gestionEditeur.addEditeur(editeur);
            return new ModelAndView("redirect:/editeur/list");
        }
    }


    @RequestMapping(value = "/editeur/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchEditeur(@RequestParam String keyWord) {
        ModelAndView mv = new ModelAndView("administratorView/editeur/list");
        mv.addObject("editeurs",gestionEditeur.getEditeurByKeyWord(keyWord));
        return mv;
    }


    @RequestMapping(value = "/editeur/list", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getEditeursList() {
        ModelAndView mv = new ModelAndView("administratorView/editeur/list");
        mv.addObject("editeurs", gestionEditeur.getAll());
        return mv;
    }


    @RequestMapping(value = "/editeur/delete", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView deleteEditeur(@RequestParam Long id) {
        gestionEditeur.deleteEditeur(id);
        return new ModelAndView("redirect:/editeur/list");
    }
}
