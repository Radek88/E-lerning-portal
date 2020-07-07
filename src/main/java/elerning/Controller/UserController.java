package elerning.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping("/adminPanel")
    private String adminPanel(){
        return "adminPanel";
    }




}
