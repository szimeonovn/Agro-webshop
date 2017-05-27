package hu.unideb.inf.web.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class LoginController{

    @GetMapping(path = "/login")
    public ModelAndView method() {
        return new ModelAndView("redirect:" + "http://localhost:3000");

    }
}
