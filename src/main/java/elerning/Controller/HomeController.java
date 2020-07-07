package elerning.Controller;

import elerning.Repository.Quiz.QuestionsRepository;
import elerning.Service.Quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    QuizService quizService;

    @Autowired
    QuestionsRepository questionsRepository;

    @RequestMapping({"/home","/"})
    private String home(){

        return "home";
    }



}
