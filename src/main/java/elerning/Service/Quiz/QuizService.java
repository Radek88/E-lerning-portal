package elerning.Service.Quiz;

import elerning.Model.Quiz.Question;
import elerning.Model.Quiz.Quiz;

import java.util.List;

public interface QuizService {



    Question findQuestionById(int id);

    void addQuestionToDB(Question question);

    boolean validateAnswer(String answer, String correctAnswer);

    Quiz findQuizById(int id);

    void addQuizToDB(Quiz quiz);

    Quiz createNewQuiz(String quizName, int numberOfQuestions);

    void saveQuiz(Quiz quiz);

    List<Quiz> listAllQuiz();



}
