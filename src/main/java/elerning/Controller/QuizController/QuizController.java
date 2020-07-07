package elerning.Controller.QuizController;


import elerning.Model.Quiz.Question;
import elerning.Model.Quiz.Quiz;
import elerning.Service.Quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashSet;

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
    private String createQuizForm() {
        return "createQuiz";
    }


    @PostMapping("/saveQuiz")
    private String createQuiz(@RequestParam("quizName") String quizName,
                              @RequestParam("numberOfQuestions") int numberOfQuestions,
                              Model model) {
        Quiz quiz = quizService.createNewQuiz(quizName, numberOfQuestions);
        Question question = new Question();
        model.addAttribute("quiz", quiz);
        model.addAttribute("question", question);

        return "createQuiz";
    }

    @PostMapping("/saveQuestionToQuiz")
    private String saveQuestionToQuiz(@ModelAttribute("quiz") Quiz quiz,
                                      @ModelAttribute("question") Question question) {
        quizService.addQuestionToDB(question);
        if (quiz.getQuestionsList() == null) {
            quiz.setQuestionsList(new HashSet<>());
            quiz.getQuestionsList().add(question);
        }
        else {
            quiz.getQuestionsList().add(question);
        }

        return "createQuiz";
    }


}
