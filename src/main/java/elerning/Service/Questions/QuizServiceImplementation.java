package elerning.Service.Questions;

import elerning.Model.Quiz.Question;
import elerning.Repository.Quiz.QuestionsRepository;
import elerning.Repository.Quiz.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void addQuestionToQuiz(int questionId) {
        Question question = questionsRepository.findById(questionId);
        quizRepository.save(question);
    }

}
