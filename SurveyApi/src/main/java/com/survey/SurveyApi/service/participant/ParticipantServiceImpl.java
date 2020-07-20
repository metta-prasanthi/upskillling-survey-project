package com.survey.SurveyApi.service.participant;

import java.util.ArrayList;
import java.util.List;

import com.survey.SurveyApi.entity.participant.Participant;
import com.survey.SurveyApi.repository.paticipant.ParticipantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	ParticipantRepository participantRepository;

	public Participant findByName(String name) {
		return participantRepository.findByFirstName(name);
    }
    
    public Participant findByEmail(String email) {
		return participantRepository.findByEmail(email);
	}

	public List<Participant> findAll() {
        List<Participant> participantList= new ArrayList<>();
        
		for (Participant participant: participantRepository.findAll()) {
			participantList.add(participant);
		}
		return participantList;
	}

	public Participant update(Participant participant) {
		return participantRepository.save(participant);
	}

	public  Participant save(Participant participant) {
		return participantRepository.save(participant);
	}

	public void deleteById(Long id) {
		participantRepository.deleteById(id);
	}

	public void deleteAll() {
		participantRepository.deleteAll();
	}

}   