package com.survey.AnswerApi.Controller;

import com.survey.AnswerApi.Model.Answer;
import com.survey.AnswerApi.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PutMapping("/answer/")
    public Answer createAnswer(@RequestBody Answer answer){return answerService.createAnswer(answer);}

    @GetMapping("/answer/{answerId}/{questionId}/{surveyId}")
    public Answer getAnswerById(@PathVariable("answerId") String answerId,@PathVariable("questionId") long questionId,
    @PathVariable("surveyId") long surveyId)
    {return answerService.getAnswer(answerId, questionId, surveyId);}

    @PostMapping("/answer/")
    public Answer updateAnswer(@RequestBody Answer answer){return answerService.updateAnswer(answer);}

    @PostMapping("/answer/delete/{id}")
    public Answer deleteAnswer(@PathVariable("id") long answerId){return answerService.deleteAnswer(answerId);}
}
