package elerning.Repository.Quiz;

import elerning.Model.Quiz.Quiz;
import elerning.Model.Quiz.Results;
import elerning.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultsRepository extends JpaRepository<Results,Integer> {



    List<Results> findAllByUserId(User user);

    List<Results> findAllByQuiz(Quiz quiz);




}
