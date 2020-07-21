package com.survey.surveyapi.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.surveyapi.dto.QuestionDTO;
import com.survey.surveyapi.entity.Question;
import com.survey.surveyapi.repository.QuestionRepository;
import com.survey.surveyapi.service.QuestionService;
import com.survey.surveyapi.service.QuestionServiceImpl;

@RestController
@RequestMapping("/surveyQuestions")
public class SurveyQuestionController {

    @Autowired
    private QuestionRepository questionRepository;
    private QuestionService questionService;

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
    @GetMapping("/hello")
    public String sayHello() {
    	return "Hello world!";
    }
    
    @SuppressWarnings("unchecked")
	@GetMapping("/")
    public List<QuestionDTO> getQuestion() {   
    	questionService = new QuestionServiceImpl(questionRepository);
        List<Question> questions = questionService.getAllQuestions();
        
        return modelMapper().map(questions, List.class);
    }
    
    @PostMapping("/")
    public QuestionDTO addQuestion(@RequestBody QuestionDTO questionDto) {   
    	questionService = new QuestionServiceImpl(questionRepository);
    	Question question = modelMapper().map(questionDto, Question.class);
        question = questionService.addQuestion(question);
        
        return modelMapper().map(question, QuestionDTO.class);
    }

    @PutMapping("/")
    public QuestionDTO updateQuestion(@RequestBody QuestionDTO questionDto) {
    	questionService = new QuestionServiceImpl(questionRepository);
    	
    	Question question = modelMapper().map(questionDto, Question.class);
        question = questionService.updateQuestion(question);
        
        return modelMapper().map(question, QuestionDTO.class);
    }
}