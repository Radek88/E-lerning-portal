package elerning.Controller;

import elerning.Model.Quiz.Results;
import elerning.Model.User;
import elerning.Repository.Quiz.ResultsRepository;
import elerning.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ResultsRepository resultsRepository;


    @GetMapping("/adminPanel")
    private String adminPanel() {
        return "userAdminPanel";
    }

    @GetMapping("/details")
    private String userDetails(Authentication auth,
                               Model model) {
        User user = userService.findByLogin(auth.getName());
        model.addAttribute("user", user);
        return "userDetails";
    }

    @GetMapping("/results")
    private String showResults(Authentication authentication,
                               Model model) {
        User user = userService.findByLogin(authentication.getName());
        List<Results> resultsList = resultsRepository.findAllByUserId(user);
        model.addAttribute("results",resultsList);


        return "quizResults";
    }


}
