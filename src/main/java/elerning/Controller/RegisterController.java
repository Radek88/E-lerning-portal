package elerning.Controller;

import elerning.Model.User;
import elerning.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    private String registerForm(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }


    @PostMapping("/save")
    private String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        } else {

            if (userService.registerNewUser(user)) {
                return "home";
            } else {

                return "register";
            }
        }
    }
}
