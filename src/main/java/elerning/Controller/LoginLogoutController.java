package elerning.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginLogoutController {

    @GetMapping("/login")
    private String log(){

        return "login";
    }

    @PostMapping("/login")
    private String login(){

        return "/home";
    }

    @PostMapping("/logout")
    private String logout(){
        return "home";
    }




}
