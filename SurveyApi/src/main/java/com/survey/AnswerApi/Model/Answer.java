package com.survey.AnswerApi.Model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String answerType;
    private String answer;
    private long questionId;
    private boolean selected = false;

    protected Answer(){}

    public Answer(String answerType, long questionId){
        this.answerType = answerType;
        this.questionId = questionId;
    }

    public long getId() {
        return id;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
