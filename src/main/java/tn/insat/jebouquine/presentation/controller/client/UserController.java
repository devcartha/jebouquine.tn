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
import tn.insat.jebouquine.data.entity.LigneCommande;
import tn.insat.jebouquine.data.entity.Panier;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
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
        ModelAndView mv = new ModelAndView("clientView/authentification/signInForm");
        mv.addObject("client", new Client());
        return mv;
    }

    @RequestMapping(value = "/client/signIn", method = RequestMethod.POST)
    public ModelAndView signIn(@ModelAttribute Client client, HttpSession httpSession) {
        Client c=gestionClient.getClientByLoginPassword(client.getLogin(),client.getPassword());
        if(c==null){
            ModelAndView mv =  new ModelAndView("clientView/authentification/signInForm");
            mv.addObject("errors",true);
            mv.addObject("erreurMsg","Login ou password incorrect");
            return mv;
        }else{
            httpSession.setAttribute("client",c);
            httpSession.setAttribute("panier",new Panier(c,new ArrayList<LigneCommande>()));
            return new ModelAndView("redirect:/catalog/list");
        }
    }

    @RequestMapping(value = "/client/formI", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getClientFormForInscribe() {
        ModelAndView mv = new ModelAndView("clientView/authentification/inscribeForm");
        mv.addObject("client", new Client());
        return mv;
    }

    @RequestMapping(value = "/client/formU", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getClientFormForUpdate(@RequestParam Long id,HttpSession httpSession) {
        if(httpSession.getAttribute("client")==null){
            return new ModelAndView("redirect:/client/signInForm");
        }
        ModelAndView mv = new ModelAndView("clientView/authentification/inscribeForm");
        mv.addObject("client", gestionClient.getClientById(id));
        return mv;
    }

    @RequestMapping(value = "/client/save", method = RequestMethod.POST)
    public ModelAndView addClient(@ModelAttribute @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("clientView/authentification/inscribeForm");
        } else {
            client.setDateInscription(new Date());
            this.gestionClient.addClient(client);
            ModelAndView mv = new ModelAndView("clientView/authentification/signInForm");
            mv.addObject("client",client);
            return mv;
        }
    }

    @RequestMapping(value = "/client/update", method = RequestMethod.POST)
    public ModelAndView updateClient(@ModelAttribute @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("clientView/authentification/inscribeForm");
        } else {
            this.gestionClient.addClient(client);
            return new ModelAndView("redirect:/client/signInForm");
        }
    }

    @RequestMapping(value = "/client/logout", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getClientFormForUpdate(HttpSession httpSession) {
        if(httpSession.getAttribute("client")==null){
            return new ModelAndView("redirect:/client/signInForm");
        }
        httpSession.invalidate();
        return new ModelAndView("redirect:/client/signInForm");
    }

}
