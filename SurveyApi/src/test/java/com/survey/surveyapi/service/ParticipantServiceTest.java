package com.survey.surveyapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.survey.surveyapi.entity.Participant;

@SpringBootTest
public class ParticipantServiceTest {

	@Autowired
    private ParticipantService participantService;
    
	@Test
	public void findParticipantByNameTest() {
		participantService.deleteAll();
    	Participant participant1 = participantService.save(new Participant(1L, "Prasanthi", "Metta", "test@test.com"));
		assertNotNull(participant1);

    	Participant participant2 = participantService.findByName("Prasanthi");
    	assertNotNull(participant2);
		assertEquals(participant2.getFirstName(), "Prasanthi");
	}

	@Test
	public void findParticipantByEmailTest() {
		participantService.deleteAll();
    	Participant participant1 = participantService.save(new Participant(1L, "Prasanthi", "Metta", "test@test.com"));
		assertNotNull(participant1);

    	Participant participant2 = participantService.findByEmail("test@test.com");
    	assertNotNull(participant2);
    	assertEquals(participant2.getEmail(), "test@test.com");
	}

	@Test
	public void findAllParticipantsTest() {
		participantService.deleteAll();
    	Participant participant1 = participantService.save(new Participant(1L, "Prasanthi", "Metta", "test@test.com"));
		assertNotNull(participant1);

    	List<Participant> participantList = participantService.findAll();
    	assertNotNull(participantList);
    	assertEquals(participantList.size(), 1);
	}

	@Test
	public void updateParticipantTest() {
		participantService.deleteAll();
		Participant participant1 = participantService.save(new Participant(1L, "Prasanthi", "Metta", "test@test.com"));
		assertNotNull(participant1);

		Participant participant2 = participantService.update(new Participant(1L, "Prasanthi", "Metta", "newemail.test.com"));
		assertNotNull(participant2);
    	assertEquals(participant2.getEmail(), "newemail.test.com");
	}
    
	@Test
	public void saveParticipantTest() {
		participantService.deleteAll();
		Participant participant1 = participantService.save(new Participant(1L, "Prasanthi", "Metta", "test@test.com"));
		assertNotNull(participant1);

		Participant participant2 = participantService.save(new Participant(2L, "Shanthi", "Metta", "shanthi@test.com"));
		assertNotNull(participant2);

    	List<Participant> participantList = participantService.findAll();
    	assertNotNull(participantList);
    	assertEquals(participantList.size(), 2);
	}

	@Test
	public void deleteParticipantByIdTest() {
		//participantService.deleteAll();
		Participant participant1 = participantService.save(new Participant(1L, "Prasanthi", "Metta", "test@test.com"));
		assertNotNull(participant1);

		Participant participant2 = participantService.save(new Participant(2L, "Shanthi", "Metta", "shanthi@test.com"));
		assertNotNull(participant2);

		participantService.deleteById(participant2.getId());
    	assertEquals(participantService.findAll().size(), 1);
	}

	@Test
	public void deleteAllParticipantsTest() {
		participantService.deleteAll();
		Participant participant1 = participantService.save(new Participant(1L, "Prasanthi", "Metta", "test@test.com"));
		assertNotNull(participant1);

		Participant participant2 = participantService.save(new Participant(2L, "Shanthi", "Metta", "shanthi@test.com"));
		assertNotNull(participant2);

		participantService.deleteAll();
		List<Participant> participantList = participantService.findAll();
    	assertEquals(participantList.size(), 0);
	}
}
