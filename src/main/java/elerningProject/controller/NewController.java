package elerningProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewController {

    @RequestMapping("/login")
    private String test(){
        return "login";
    }

}
