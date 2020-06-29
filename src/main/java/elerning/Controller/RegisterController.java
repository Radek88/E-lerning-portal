package elerning.Controller;

import elerning.Model.User;
import elerning.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    private String test(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/saveUser")
    private String saveUser(@RequestParam("name") String name,
                          @RequestParam("surname") String surname,
                          @RequestParam("login") String login,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password
                          ) {
        User user = new User(login, name, surname,"user", password, email);

        userService.saveUser(user);
        return "login";
    }

}

