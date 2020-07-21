package com.survey.surveyapi.controller;

import java.util.List;

import com.survey.surveyapi.entity.Participant;
import com.survey.surveyapi.service.ParticipantServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private ParticipantServiceImpl participantService;

	@GetMapping(value = "/{email}")
	public Participant getParticipantByEmail(@PathVariable String email) {
		return participantService.findByEmail(email);
	}
    
    @GetMapping("/")
	public List<Participant> getAllParticipants() {
		return participantService.findAll();
    }

	@PostMapping(value = "/")
	public Participant save(@RequestBody Participant participant) {
		return participantService.save(participant);
    }
    
    @PutMapping(value = "/")
	public Participant update(@RequestBody Participant participant) {
		return participantService.save(participant);
	}

	@DeleteMapping(value = "/")
	public void delete() {
		participantService.deleteAll();
	}

	@DeleteMapping("/{id}")
	public void deleteParticipantBySummary(@PathVariable Long id) {
		participantService.deleteById(id);
	}
}