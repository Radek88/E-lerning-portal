package elerning.Service.Quiz;

import elerning.Model.Quiz.Quiz;
import elerning.Model.Quiz.Results;
import elerning.Model.User;

import java.util.List;

public interface ResultsServices {

    List<Results> findByUser(User user);

    List<Results>findByQuiz(Quiz quiz);

    void saveResultToDB(Results result);

}
