package tn.insat.jebouquine.presentation.controller.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionCommande;

import javax.servlet.http.HttpSession;

/**
 * Created by Devcartha on 12/17/2015.
 */
@Controller
@Scope(value = "session")
public class CommandeController {

    @Autowired
    IGestionCommande gestionCommande;

    @RequestMapping(value = "/commande/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchCommande(@RequestParam String keyWord,HttpSession httpSession) {
        if(httpSession.getAttribute("admin")==null){
            return new ModelAndView("redirect:/admin/loginForm");
        }
        ModelAndView mv = new ModelAndView("administratorView/commande/list");
        mv.addObject("commandes",gestionCommande.getEditeurByKeyWord(keyWord));
        return mv;
    }

    @RequestMapping(value = "/commande/list", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getCommandesList(HttpSession httpSession) {
        if(httpSession.getAttribute("admin")==null){
            return new ModelAndView("redirect:/admin/loginForm");
        }
        ModelAndView mv = new ModelAndView("administratorView/commande/list");
        mv.addObject("commandes", gestionCommande.getAll());
        return mv;
    }
}
