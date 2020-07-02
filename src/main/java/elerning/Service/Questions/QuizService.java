package elerning.Service.Questions;

import elerning.Model.Quiz.Question;

public interface QuizService {

    Question findQuestionById(int id);

    void addQuestionToDB(Question question);

    boolean validateAnswer(String answer, String correctAnswer);

    void addQuestionToQuiz(int questionId);



}
