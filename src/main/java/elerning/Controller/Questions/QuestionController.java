package elerning.Controller.Questions;


import elerning.Model.Questions.Question;
import elerning.Service.Questions.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/quiz")
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/displayQuestion")
    private String displayQuestion(Model model) {

        Question question = questionService.findQuestionById(1);
        model.addAttribute("question",question);

        return "displayQuestion";
    }

    @PostMapping("/answer")
    private String getAnswer(/*@RequestParam(value = "answer") String answer,
                             @RequestParam(value = "correct") String correctAnswer,
                             Model model*/){
        System.out.println("answer");
        System.out.println("correctAnswer");


        return "displayQuestion";
    }


}
