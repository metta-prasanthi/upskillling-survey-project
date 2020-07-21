package com.survey.surveyapi.controller.participant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.survey.surveyapi.entity.participant.Participant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ParticipantControllerTest {

    private final ObjectMapper mapper = new JsonMapper();

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void getAllParticipantsTest() {
        try {
            mockMvc.perform(get("/participant/"))
            	.andDo(print())
            	.andExpect(status().isOk())
            	.andExpect(jsonPath("$").isArray());

            mockMvc.perform(get("/participant/").content(mapper.writeValueAsString(new Participant()))
                    .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void saveParticipantTest() {

        try {
            mockMvc.perform(post("/participant/").content(mapper.writeValueAsString(new Participant()))
            .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").isEmpty());
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void updateParticipantTest() {

        try {
            mockMvc.perform(put("/participant/").content(mapper.writeValueAsString(new Participant()))
            .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").isEmpty());
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void deleteParticipantTest() {

        try {
            mockMvc.perform(delete("/participant/").content(mapper.writeValueAsString(new Participant()))
            .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
        } catch (Exception e) {
            fail("Should not have exception: " + e.getLocalizedMessage());
        }
    }
}
