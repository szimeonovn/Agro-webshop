package hu.unideb.inf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Szimi7 on 2017.05.25..
 */
@Controller
public class LoginController {

    @RequestMapping(path = {"/login"},method = RequestMethod.GET)
    public String loadIndexView(){
        return "index.html";
    }

}
