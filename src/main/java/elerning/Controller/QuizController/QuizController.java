package elerning.Controller.QuizController;


import elerning.Model.Quiz.Question;
import elerning.Service.Questions.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/quiz")
@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/displayQuestion")
    private String displayQuestion(Model model, Integer questionId) {
        Question question = quizService.findQuestionById(questionId);
        model.addAttribute("question", question);
        return "displayQuestion";
    }

    @PostMapping("/answer")
    private String getAnswer(
            @RequestParam(value = "correct") String correctAnswer,
            @RequestParam(value = "answer") String answer,
            Model model) {
        Integer questionId = 1;
        boolean isAnswerCorrect = quizService.validateAnswer(answer, correctAnswer);
        model.addAttribute(quizService.findQuestionById(2));
        return displayQuestion(model, questionId);
    }

    @GetMapping("/createQuiz")
    private String createQuiz() {
        return "createQuiz";
    }


}
