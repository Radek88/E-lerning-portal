package elerning.Service.Questions;

import elerning.Model.Questions.Question;
import elerning.Repository.Questions.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImplementation implements QuestionService {

    @Autowired
    private QuestionsRepository questionsRepository;

    @Override
    public Question findQuestionById(int id) {
        return questionsRepository.findById(id);
    }

    @Override
    public void addQuestionToDB(Question question) {
        questionsRepository.saveAndFlush(question);
    }
}
