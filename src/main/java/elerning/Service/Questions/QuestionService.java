package elerning.Service.Questions;

import elerning.Model.Questions.Question;

public interface QuestionService {

    public Question findQuestionById(int id);

    public void addQuestionToDB(Question question);



}
