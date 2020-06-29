package elerning.Controller;

import elerning.Model.User;
import elerning.Service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequestMapping("/user")
@Controller
public class UserController {
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

                ObjectError objectError = new ObjectError("userExist", "Login already used");
                bindingResult.addError(objectError);
                return "register";
            }
        }
    }

    @PostMapping
    private String login(String login, String password, HttpRequest request, HttpResponse response){

        if(userService.findByLogin(login)!=null && userService.findByLogin(login).getPassword().equals(password)){
           User user = userService.findByLogin(login);


        }

        return "home";
    }


}
