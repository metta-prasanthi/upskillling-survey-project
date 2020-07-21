package com.survey.surveyapi.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.survey.surveyapi.entity.Answer;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnswerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    private Answer testAnswer = new Answer("MULTIPLECHOICE", "A", 1L,1L);

    //@Test
    //@Order(1)
    public void answerApiTest(){

        try{
            mockMvc.perform(put("/answer/").content(mapper.writeValueAsString(
                    testAnswer)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
                    .andExpect(status().isOk()).andExpect(jsonPath("$.answerType").value("MULTIPLECHOICE"));
        }catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }

    }

    //@Test
    //@Order(2)
    public void test2(){
        try{
            testAnswer.setId(1);
            testAnswer.setAnswerText("test answer");
            testAnswer.setSelected(true);
            mockMvc.perform(post("/answer/").content(mapper.writeValueAsString(
                    testAnswer)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
                    .andExpect(status().isOk()).andExpect(jsonPath("$.answerType").value("MULTIPLECHOICE"));

        }catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    //@Test
    //@Order(3)
    public void test3(){
        try{
            System.out.println(testAnswer.getId());
            mockMvc.perform(get("/answer/A/1/1")).andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$.answerText").value("test answer"));

        }catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    //@Test
    //@Order(4)
    public void test4(){
        try{
            mockMvc.perform(post("/answer/delete/1").content(mapper.writeValueAsString(
                    testAnswer)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
                    .andExpect(status().isOk()).andExpect(jsonPath("$.answerText").value("test answer"));

        }catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

}
