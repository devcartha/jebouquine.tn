package tn.insat.jebouquine.presentation.controller.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionCategorie;
import tn.insat.jebouquine.data.entity.Categorie;

import javax.validation.Valid;

/**
 * Created by Devcartha on 12/14/2015.
 */
@Controller
public class CategorieController {

    @Autowired
    IGestionCategorie gestionCategorie;

    @RequestMapping(value = "/categorie/formI", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getCategorieFormForInsertion() {
        ModelAndView mv = new ModelAndView("administratorView/categorie/form");
        mv.addObject("categorie", new Categorie());
        return mv;
    }

    @RequestMapping(value = "/categorie/formU", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getCategorieFormForUpdate(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("administratorView/categorie/form");
        mv.addObject("categorie", gestionCategorie.getCategorieById(id));
        return mv;
    }

    @RequestMapping(value = "/categorie/save", method = RequestMethod.POST)
    public ModelAndView addCategorie(@ModelAttribute @Valid Categorie categorie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("administratorView/categorie/form");
        } else {
            this.gestionCategorie.addCategorie(categorie);
            return new ModelAndView("redirect:/categorie/list");
        }
    }

    @RequestMapping(value = "/categorie/update", method = RequestMethod.POST)
    public ModelAndView updateCategorie(@ModelAttribute @Valid Categorie categorie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("administratorView/categorie/form");
        } else {
            this.gestionCategorie.addCategorie(categorie);
            return new ModelAndView("redirect:/categorie/list");
        }
    }


    @RequestMapping(value = "/categorie/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchCategorie(@RequestParam String keyWord) {
        ModelAndView mv = new ModelAndView("administratorView/categorie/list");
        mv.addObject("categories",gestionCategorie.getCategorieByTitre(keyWord));
        return mv;
    }


    @RequestMapping(value = "/categorie/list", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getCategoriesList() {
        ModelAndView mv = new ModelAndView("administratorView/categorie/list");
        mv.addObject("categories", gestionCategorie.getAll());
        return mv;
    }


    @RequestMapping(value = "/categorie/delete", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView deleteCategorie(@RequestParam Long id) {
        gestionCategorie.deleteCategorie(id);
        return new ModelAndView("redirect:/categorie/list");
    }

}
