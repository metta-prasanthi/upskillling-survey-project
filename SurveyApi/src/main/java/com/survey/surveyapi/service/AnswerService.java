package com.survey.surveyapi.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.surveyapi.entity.Answer;
import com.survey.surveyapi.repository.AnswerRepo;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepo answerRepo;

    public Answer createAnswer(Answer answer){
        answerRepo.saveAndFlush(answer);
        return answerRepo.findById(answer.getId()).get();
    }

    public Answer getAnswer(String answerId, long questionId, long surveyId){
        System.out.println(answerId+" "+questionId+" "+surveyId);
        return answerRepo.findByAnswerIdAndAndQuestionIdAndAndSurveyId(answerId, questionId, surveyId);
    }

    public Answer updateAnswer(Answer answer){
        answerRepo.saveAndFlush(answer);
        return answerRepo.findById(answer.getId()).get();
    }

    public Answer deleteAnswer(long answerId){
        Answer deleted = answerRepo.findById(answerId).get();
        answerRepo.deleteById(answerId);
        return deleted;
    }

    public Set<Answer> getAllAnswersByQuestion(long questionId){
        return answerRepo.findAllByQuestionId(questionId);
    }
}
