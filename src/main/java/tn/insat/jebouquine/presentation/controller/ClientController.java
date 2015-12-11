package tn.insat.jebouquine.presentation.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tn.insat.jebouquine.data.entity.Client;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Devcartha on 12/7/2015.
 */
@Controller
public class ClientController {

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "dateInscription", new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/boot", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView boot(){
        return new ModelAndView("bootsrap");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView signUp(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("client",new Client());
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView register(@Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("index");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("client",client);
        mv.setViewName("success");
        return mv;
    }

}
