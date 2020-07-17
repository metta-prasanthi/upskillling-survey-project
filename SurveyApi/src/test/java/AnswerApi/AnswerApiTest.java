package AnswerApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.survey.AnswerApi.Model.Answer;
//import com.survey.SurveyApi.SurveyApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest(classes = SurveyApiApplication.class)
@AutoConfigureMockMvc
public class AnswerApiTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void answerApiTest(){
        Answer testAnswer = new Answer("MULTIPLECHOICE", 1L);
        try{
            mockMvc.perform(put("/answer/").content(mapper.writeValueAsString(
                    testAnswer)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
                    .andExpect(status().isOk()).andExpect(jsonPath("$.answerType").value("MULTIPLECHOICE"));
            testAnswer.setAnswer("test answer");
            testAnswer.setSelected(true);
            mockMvc.perform(post("/answer/").content(mapper.writeValueAsString(
                    testAnswer)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
                    .andExpect(status().isOk()).andExpect(jsonPath("$.answerType").value("MULTIPLECHOICE"));
            mockMvc.perform(get("/answer/0")).andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$.answer").value("test answer"));
            mockMvc.perform(post("/answer/delete/0").content(mapper.writeValueAsString(
                    testAnswer)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
                    .andExpect(status().isOk()).andExpect(jsonPath("$.answer").value("test answer"));
        }catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }

    }
}
