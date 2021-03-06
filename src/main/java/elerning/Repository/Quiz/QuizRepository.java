package elerning.Repository.Quiz;

import elerning.Model.Quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {

    Quiz findById(int id);

    List<Quiz>findAll();



}
