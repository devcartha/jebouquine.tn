package tn.insat.jebouquine.presentation.controller.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionClient;

import javax.servlet.http.HttpSession;

/**
 * Created by Devcartha on 12/14/2015.
 */
@Controller
@Scope(value = "session")
public class ClientController {

    @Autowired
    IGestionClient gestionClient;

    @RequestMapping(value = "/client/search", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchClient(@RequestParam String keyWord,HttpSession httpSession) {
        if(httpSession.getAttribute("admin")==null){
            return new ModelAndView("redirect:/admin/loginForm");
        }
        ModelAndView mv = new ModelAndView("administratorView/client/list");
        mv.addObject("clients",gestionClient.getClientsByKeyWord(keyWord));
        return mv;
    }

    @RequestMapping(value = "/client/list", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getClientsList(HttpSession httpSession) {
        if(httpSession.getAttribute("admin")==null){
            return new ModelAndView("redirect:/admin/loginForm");
        }
        ModelAndView mv = new ModelAndView("administratorView/client/list");
        mv.addObject("clients", gestionClient.getAll());
        return mv;
    }
}
