package elerning.Controller.Questions;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/quiz")
@Controller
public class QuestionController {

    @GetMapping("/displayQuestion")
    private String displayQuestion() {
        return "displayQuestion";
    }


}
