package tn.insat.jebouquine.presentation.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionOuvrage;
import tn.insat.jebouquine.data.entity.Avi;
import tn.insat.jebouquine.data.entity.Client;
import tn.insat.jebouquine.data.entity.Ouvrage;
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
    IAviRepository aviRepository;

    @RequestMapping(value = "/catalog/list", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvragesList() {
        ModelAndView mv = new ModelAndView("clientView/ouvrage/list");
        mv.addObject("ouvrages", gestionOuvrage.getAll());
        return mv;
    }

    @RequestMapping(value = "/catalog/details", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getOuvrageDetails(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("clientView/ouvrage/details");
        Ouvrage ouvrage = gestionOuvrage.getOuvrageById(id);
        mv.addObject("ouvrage",ouvrage);
        mv.addObject("avis",gestionOuvrage.getAvisClients(ouvrage));
        mv.addObject("avi",new Avi());
        return mv;
    }

    @RequestMapping(value = "/catalog/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView deleteOuvrage(@RequestParam String keyWord) {
        ModelAndView mv = new ModelAndView("clientView/ouvrage/list");
        mv.addObject("ouvrages",gestionOuvrage.getOuvrageByKeyWord(keyWord));
        return mv;
    }

    @RequestMapping(value = "/catalog/avi", method = RequestMethod.POST)
    public ModelAndView signIn(@ModelAttribute Avi avi,@RequestParam Long id, HttpSession httpSession) {
        ModelAndView mv = new ModelAndView("clientView/ouvrage/details");
        Ouvrage ouvrage = gestionOuvrage.getOuvrageById(id);
        avi.setClient((Client) httpSession.getAttribute("client"));
        System.out.println((Client)httpSession.getAttribute("client"));
        avi.setOuvrage(ouvrage);
        aviRepository.save(avi);
        mv.addObject("ouvrage",ouvrage);
        mv.addObject("avis",gestionOuvrage.getAvisClients(ouvrage));
        return mv;
    }


}
