package elerning.Model.Quiz;

import elerning.Model.User;

import javax.persistence.*;

@Entity
@Table(name="user_results")
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="result_id")
    private int result_id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name= "userId",referencedColumnName = "usr_id")
    private User userId;

   /* @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="id", referencedColumnName = "result_id")
    private User user_id;*/

    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "quiz",referencedColumnName = "id")
    private Quiz quiz;

    private int number_of_correct_answer;

    private int total_number_of_questions;


    public Results() {
    }

    public Results(User userId, Quiz quiz, int number_of_correct_answer, int total_number_of_questions) {
        this.userId = userId;
        this.quiz = quiz;
        this.number_of_correct_answer = number_of_correct_answer;
        this.total_number_of_questions = total_number_of_questions;

    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User user) {
        this.userId = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public int getNumber_of_correct_answer() {
        return number_of_correct_answer;
    }

    public void setNumber_of_correct_answer(int number_of_correct_answer) {
        this.number_of_correct_answer = number_of_correct_answer;
    }

    public int getTotal_number_of_questions() {
        return total_number_of_questions;
    }

    public void setTotal_number_of_questions(int total_number_of_questions) {
        this.total_number_of_questions = total_number_of_questions;
    }
}
