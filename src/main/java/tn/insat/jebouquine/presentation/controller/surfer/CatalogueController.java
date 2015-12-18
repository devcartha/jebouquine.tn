package tn.insat.jebouquine.presentation.controller.surfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionAvi;
import tn.insat.jebouquine.business.facade.IGestionOuvrage;
import tn.insat.jebouquine.data.entity.Avi;
import tn.insat.jebouquine.data.entity.Ouvrage;

/**
 * Created by Devcartha on 12/14/2015.
 */
@Controller
public class CatalogueController {

    @Autowired
    IGestionOuvrage gestionOuvrage;
    @Autowired
    IGestionAvi gestionAvi;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index() {
        return new ModelAndView("redirect:/catalogue/list");
    }

    @RequestMapping(value = "/catalogue/list", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvragesList() {
        ModelAndView mv = new ModelAndView("surferView/ouvrage/list");
        mv.addObject("ouvrages", gestionOuvrage.getAll());
        return mv;
    }

    @RequestMapping(value = "/catalogue/details", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvrageDetails(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("surferView/ouvrage/details");
        Ouvrage ouvrage = gestionOuvrage.getOuvrageById(id);
        mv.addObject("ouvrage",ouvrage);
        mv.addObject("avis",gestionOuvrage.getAvisClients(ouvrage));
        mv.addObject("avi",new Avi());
        return mv;
    }

    @RequestMapping(value = "/catalogue/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView deleteOuvrage(@RequestParam String keyWord) {
        ModelAndView mv = new ModelAndView("surferView/ouvrage/list");
        mv.addObject("ouvrages",gestionOuvrage.getOuvrageByKeyWord(keyWord));
        return mv;
    }


}
