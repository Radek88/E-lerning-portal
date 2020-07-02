package elerning.Controller;

import elerning.Model.Quiz.Question;
import elerning.Model.Quiz.Quiz;
import elerning.Repository.Quiz.QuestionsRepository;
import elerning.Service.Questions.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

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
