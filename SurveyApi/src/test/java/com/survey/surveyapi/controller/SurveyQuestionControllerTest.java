package com.survey.surveyapi.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.survey.surveyapi.entity.Question;
import com.survey.surveyapi.service.QuestionServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class SurveyQuestionControllerTest {

    private static String ENDPOINT_URL = "/surveyQuestions/";
    
    @Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private QuestionServiceImpl questionSvc;
	 
	@Test
	void testQuestions() throws Exception {
		List<Question> questions = new ArrayList<>();
		questions.add(new Question("Hows the weather?", "checkbox"));
		questions.add(new Question("Hows the class?", "checkbox"));
		when(questionSvc.getAllQuestions()).thenReturn(questions);
		
		this.mockMvc.perform(get(ENDPOINT_URL)).andDo(print()).andExpect(status().isOk());
	}
}