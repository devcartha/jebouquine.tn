package tn.insat.jebouquine.presentation.controller.administrator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.data.entity.Admin;
import tn.insat.jebouquine.data.entity.Client;
import tn.insat.jebouquine.data.entity.LigneCommande;
import tn.insat.jebouquine.data.entity.Panier;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by Devcartha on 12/18/2015.
 */
@Controller
@Scope(value = "session")
public class LoginController {

    @RequestMapping(value = "/admin/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index() {
       return new ModelAndView("redirect:/admin/loginForm");
    }

    @RequestMapping(value = "/admin/loginForm", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAdminSignInForm() {
        ModelAndView mv = new ModelAndView("administratorView/authentification/signInForm");
        mv.addObject("admin", new Admin());
        return mv;
    }

    @RequestMapping(value = "/admin/signIn", method = RequestMethod.POST)
    public ModelAndView signIn(@ModelAttribute Admin admin, HttpSession httpSession) {
        if (admin.getLogin().equals("admin")&&admin.getPassword().equals("admin")){
            httpSession.setAttribute("admin",admin);
            return new ModelAndView("redirect:/ouvrage/list");
        }
        ModelAndView mv =  new ModelAndView("administratorView/authentification/signInForm");
        mv.addObject("errors",true);
        mv.addObject("erreurMsg","Login ou password incorrect");
        return mv;
    }

    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getClientFormForUpdate(HttpSession httpSession) {
        httpSession.invalidate();
        return new ModelAndView("redirect:/admin/loginForm");
    }
}
