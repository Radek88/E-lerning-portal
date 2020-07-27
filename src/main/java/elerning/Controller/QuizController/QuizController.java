package elerning.Controller.QuizController;


import elerning.Model.Quiz.*;
import elerning.Model.User;
import elerning.Repository.Quiz.ResultsRepository;
import elerning.Service.Quiz.CategoriesService;
import elerning.Service.Quiz.QuizService;
import elerning.Service.Quiz.ResultsServices;
import elerning.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.mail.internet.InternetAddress;
import java.util.*;

@RequestMapping("/quiz")
@Controller
public class QuizController {


    @Autowired
    private QuizService quizService;

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private ResultsServices resultsServices;

    @Autowired
    private UserService userService;

    private List<UserQuizAnswers> userAnswers;

    private int result = 0;


    @GetMapping("/displayQuestion")
    private String displayQuestion(Model model, Integer questionId) {
        Question question = quizService.findQuestionById(questionId);
        model.addAttribute("question", question);
        return "displayQuestion";
    }

   /* @PostMapping("/answer")
    private String getAnswer(
            @RequestParam(value = "correct") String correctAnswer,
            @RequestParam(value = "answer") String answer,
            Model model) {

        boolean isAnswerCorrect = quizService.validateAnswer(answer, correctAnswer);
        model.addAttribute(quizService.findQuestionById(2));
        return displayQuestion(model);
    }*/

    @GetMapping("/createQuiz")
    private String createQuizForm(Model model) {
        List<Categories> categoriesList = categoriesService.findAll();
        model.addAttribute("categoriesList", categoriesList);
        return "createQuiz";
    }


    @PostMapping("/saveQuiz")
    private String createQuiz(@RequestParam("quizName") String quizName,
                              @RequestParam("category") String cat,
                              Model model) {

        Categories category = categoriesService.findByCategoryName(cat);
        Quiz quiz = quizService.createNewQuiz(quizName, category);
        Question question = new Question();
        model.addAttribute("quiz", quiz);
        model.addAttribute("question", question);

        return "createQuiz";
    }

    @PostMapping("/saveQuestionToQuiz")
    private String saveQuestionToQuiz(@ModelAttribute("quizId") int quizId,
                                      @ModelAttribute("question") Question question,
                                      Model model) {
        Quiz quiz = quizService.findQuizById(quizId);
        quizService.addQuestionToDB(question);
        if (quiz.getQuestionsList() == null) {
            quiz.setQuestionsList(new LinkedList<>());
            quiz.getQuestionsList().add(question);
            quizService.saveQuiz(quiz);
        } else {
            quiz.getQuestionsList().add(question);
            quizService.saveQuiz(quiz);
        }
        Question newQuestion = new Question();
        model.addAttribute("quiz", quiz);
        model.addAttribute("question", newQuestion);
        return "createQuiz";
    }

    @PostMapping("/quizCompleted")
    private String quizCompleted(@ModelAttribute("quizId") int quizId,
                                 Model model) {
        Quiz quiz = quizService.findQuizById(quizId);
        model.addAttribute("completedQuiz", quiz);
        return "createQuiz";
    }

    @GetMapping("/listQuiz")
    private String listQuiz(Model model) {
        List<Quiz> quizList = quizService.listAllQuiz();
        model.addAttribute("quizList", quizList);

        return "listQuiz";
    }

    //TODO obsłużyć skrajny przypadek z quizem bez żadnego pytania.
    //TODO zaimplementować sprawdzanie poprawnych odpowiedzi oraz ich zliczanie

    @RequestMapping("/startQuiz")
    private String startQuiz(Model model,
                             @RequestParam(value = "quizId") Integer quizId,
                             @RequestParam(value = "questionId", required = false) Integer questionId,
                             @RequestParam(value = "correct", required = false) String correctAnswer,
                             @RequestParam(value = "answer", required = false) String answer,
                             Authentication authentication) {


        Quiz quiz = quizService.findQuizById(quizId);
        User user = userService.findByLogin(authentication.getName());
        model.addAttribute("quiz", quiz);
        if (questionId == null) {

            userAnswers = new LinkedList<>();

            model.addAttribute("question", quiz.getQuestionsList().get(0));

            return "displayQuestion";


        } else {

            Question actualQuestion = quizService.findQuestionById(questionId);
            UserQuizAnswers tmpAnswerObject = new UserQuizAnswers(actualQuestion, answer, correctAnswer);
            userAnswers.add(tmpAnswerObject);
            if (tmpAnswerObject.isCorrect()) {
                result++;
            }


            Integer nextQuestionOnList = quiz.getQuestionsList().indexOf(actualQuestion);


            if (nextQuestionOnList == quiz.getQuestionsList().size() - 1) {

                model.addAttribute("userAnswers", userAnswers);
                model.addAttribute("result", result);
                model.addAttribute("numberOfQuestions", quiz.getQuestionsList().size());
                Results actualQuzResult = new Results(user, quiz, result, quiz.getQuestionsList().size());
                resultsServices.saveResultToDB(actualQuzResult);
                result = 0;
                return "quizResult";
            }

            Integer nextQuestionId = quiz.getQuestionsList().get(nextQuestionOnList + 1).getId();
            return displayQuestion(model, nextQuestionId);
        }
    }


}
