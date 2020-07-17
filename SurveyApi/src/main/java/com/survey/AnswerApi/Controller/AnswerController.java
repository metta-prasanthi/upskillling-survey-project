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

    @RequestMapping("/")
    public String index(){return "Answer API";}

    @PutMapping("/answer/")
    public Answer createAnswer(@RequestBody Answer answer){return answerService.createAnswer(answer);}

    @GetMapping("/answer/{id}")
    public Answer getAnswerById(@PathVariable("id") long answerId){return answerService.getAnswer(answerId);}

    @GetMapping("/answer/question/{id}")
    public Set<Answer> getAnswerByQuestionId(@PathVariable("id") long questionId){return answerService.getAllAnswersByQuestion(questionId);}

    @PostMapping("/answer/")
    public Answer updateAnswer(@RequestBody Answer answer){return answerService.updateAnswer(answer);}

    @PostMapping("/answer/delete/{id}")
    public Answer deleteAnswer(@PathVariable("id") long answerId){return answerService.deleteAnswer(answerId);}
}
