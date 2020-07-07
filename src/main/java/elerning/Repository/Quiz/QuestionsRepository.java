package elerning.Repository.Quiz;

import elerning.Model.Quiz.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Question,Integer> {

    Question findById(int id);

    List<Question> findAll();

}
