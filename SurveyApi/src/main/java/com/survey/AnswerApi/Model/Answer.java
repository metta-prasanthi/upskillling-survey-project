package com.survey.AnswerApi.Model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum Type{
        MULTIPLECHOICE,
        SHORTANSWER,
        CHECKBOX,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @Enumerated(EnumType.STRING)
    private Type answerType;
    @Column
    private String answer;
    @Column
    private long questionId;
    @Column
    private boolean selected = false;

    protected Answer(){}

    public Answer(Type answerType, long questionId){
        this.answerType = answerType;
        this.questionId = questionId;
    }

    public long getId() {
        return id;
    }

    public Type getAnswerType() {
        return answerType;
    }

    public void setAnswerType(Type answerType) {
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
