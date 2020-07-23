package elerning.Model.Quiz;

public class UserQuizAnswers {


    private String questionText;
    private String answer;
    private String correctAnswer;
    private boolean isCorrect;

    public UserQuizAnswers(Question question, String answer, String correctAnswer) {
        this.questionText = question.getQuestionText();
        this.answer = setAnswerText(answer,question);
        this.correctAnswer = setAnswerText(correctAnswer,question);
        this.isCorrect = answer.equals(correctAnswer);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionId() {
        return questionText;
    }

    public void setQuestionId(String questionText) {
        this.questionText = questionText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    private String setAnswerText(String answerLetter, Question question){

        switch(answerLetter){
            case "A": return question.getA();
            case "B": return question.getB();
            case "C": return question.getC();
            case "D": return question.getD();
        }
        return "Error";
    }

}

