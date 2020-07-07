package elerning.Model.Quiz;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String quizName;

    private int numberOfQuestions;

    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_id")
    private Set<Question> questionsList;


    public Quiz(int id, String quizName, Set<Question> questionsList) {
        this.quizName = quizName;
        this.questionsList = questionsList;
    }

    public Quiz(String quizName, int numberOfQuestions) {
        this.quizName = quizName;
        this.numberOfQuestions = numberOfQuestions;
    }

    public Quiz() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Set<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(Set<Question> questionsList) {
        this.questionsList = questionsList;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
}
