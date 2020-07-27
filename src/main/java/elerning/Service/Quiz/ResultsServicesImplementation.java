package elerning.Service.Quiz;

import elerning.Model.Quiz.Quiz;
import elerning.Model.Quiz.Results;
import elerning.Model.User;
import elerning.Repository.Quiz.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResultsServicesImplementation implements ResultsServices {

    @Autowired
    ResultsRepository resultsRepository;


    @Override
    public List<Results> findByUser(User user) {
        return resultsRepository.findAllByUserId(user);
    }

    @Override
    public List<Results> findByQuiz(Quiz quiz) {
        return resultsRepository.findAllByQuiz(quiz);
    }

    @Override
    public void saveResultToDB(Results result) {
        resultsRepository.saveAndFlush(result);
    }
}
