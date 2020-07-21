/**
 * 
 */
package com.survey.surveyapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.surveyapi.entity.Question;
import com.survey.surveyapi.repository.QuestionRepository;

/**
 * This is an implementation class for Question Service.
 * 
 * @author engwbsp
 *
 */

@Service
public class QuestionServiceImpl implements QuestionService {	

	@Autowired
	private QuestionRepository questionRepository;

	public QuestionServiceImpl(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
		
	public Optional<Question> getQuestionById(Long id) {
		return questionRepository.findById(id);
	}
	
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}
	
	public List<Question> addQuestions(List<Question> questions) {
		return questionRepository.saveAll(questions);
	}

	public Question updateQuestion(Question question) {
		return questionRepository.save(question);
	}

	public void deleteQuestion(Question question) {
		questionRepository.delete(question);
	}
	
	public void deleteQuestions() {
		questionRepository.deleteAll();
	}
	
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}	
}
