package elerning.Controller;


import elerning.Model.User;
import elerning.Repository.UserRepository;
import elerning.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/login")
    private String test(){

        return "login";
    }


}
