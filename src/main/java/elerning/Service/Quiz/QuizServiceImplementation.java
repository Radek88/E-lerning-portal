package elerning.Service.Quiz;

import elerning.Model.Categories;
import elerning.Model.Quiz.Question;
import elerning.Model.Quiz.Quiz;
import elerning.Repository.Quiz.QuestionsRepository;
import elerning.Repository.Quiz.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImplementation implements QuizService {

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Question findQuestionById(int id) {
        return questionsRepository.findById(id);
    }

    @Override
    public void addQuestionToDB(Question question) {
        questionsRepository.saveAndFlush(question);
    }

    @Override
    public boolean validateAnswer(String answer, String correctAnswer) {
        return answer.equals(correctAnswer);
    }


    @Override
    public void addQuizToDB(Quiz quiz) {
        quizRepository.save(quiz);
    }

    @Override
    public Quiz createNewQuiz(String quizName, Categories category) {
        Quiz quiz = new Quiz(quizName);
        quiz.setCategory(category);
        quizRepository.save(quiz);
        return quiz;
    }

    @Override
    public void saveQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    @Override
    public Quiz findQuizById(int id) {

        return quizRepository.findById(id);
    }

    @Override
    public List<Quiz> listAllQuiz() {
        return quizRepository.findAll();
    }

}
