package tn.insat.jebouquine.presentation.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.business.facade.IGestionClient;
import tn.insat.jebouquine.data.entity.Auteur;
import tn.insat.jebouquine.data.entity.Client;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created by Devcartha on 12/14/2015.
 */
@Controller
@Scope(value = "session")
public class UserController {

    @Autowired
    IGestionClient gestionClient;

    @RequestMapping(value = "/client/signInForm", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getClientFormForSignIn() {
        ModelAndView mv = new ModelAndView("clientView/client/signInForm");
        mv.addObject("client", new Client());
        return mv;
    }

    @RequestMapping(value = "/client/signIn", method = RequestMethod.POST)
    public ModelAndView signIn(@ModelAttribute Client client, HttpSession httpSession) {
        Client c=gestionClient.getClientByLoginPassword(client.getLogin(),client.getPassword());
        if(c==null)
            return new ModelAndView("redirect:/client/signInForm");
        else{
            httpSession.setAttribute("client",c);
            return new ModelAndView("redirect:/catalog/list");
        }
    }

    @RequestMapping(value = "/client/formI", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getClientFormForInscribe() {
        ModelAndView mv = new ModelAndView("clientView/client/inscribeForm");
        mv.addObject("client", new Client());
        return mv;
    }

    @RequestMapping(value = "/client/formU", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getClientFormForUpdate(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("clientView/client/inscribeForm");
        mv.addObject("client", gestionClient.getClientById(id));
        return mv;
    }

    @RequestMapping(value = "/client/save", method = RequestMethod.POST)
    public ModelAndView addClient(@ModelAttribute @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("clientView/client/inscribeForm");
        } else {
            client.setDateInscription(new Date());
            this.gestionClient.addClient(client);
            return new ModelAndView("redirect:/client/signInForm");
        }
    }

    @RequestMapping(value = "/client/update", method = RequestMethod.POST)
    public ModelAndView updateClient(@ModelAttribute @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("clientView/client/inscribeForm");
        } else {
            this.gestionClient.addClient(client);
            return new ModelAndView("redirect:/client/signInForm");
        }
    }

}
