package elerning.Controller;

import elerning.Model.User;
import elerning.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/adminPanel")
    private String adminPanel(){
        return "adminPanel";
    }

    @GetMapping("/details")
    private String userDetails(Authentication auth,
                               Model model){
        User user = userService.findByLogin(auth.getName());
        model.addAttribute("user", user);
        return "details";
    }




}
