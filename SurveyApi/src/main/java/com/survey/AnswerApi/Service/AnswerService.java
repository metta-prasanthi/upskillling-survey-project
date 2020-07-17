package com.survey.AnswerApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.survey.AnswerApi.Model.Answer;

import java.util.Set;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepo answerRepo;

    public Answer createAnswer(Answer answer){
        answerRepo.save(answer);
        return answer;
    }

    public Answer getAnswer(long answerId){
//        return answerRepo.findByAnswerId(answerId);
        return answerRepo.findById(answerId).get();
    }

    public Answer updateAnswer(Answer answer){
        answerRepo.save(answer);
        return answer;
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
