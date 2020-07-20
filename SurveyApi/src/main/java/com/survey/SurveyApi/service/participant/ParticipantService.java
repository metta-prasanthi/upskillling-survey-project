package com.survey.SurveyApi.service.participant;

import java.util.List;

import com.survey.SurveyApi.entity.participant.Participant;

public interface ParticipantService {	

    public Participant findByName(String name);

    public Participant findByEmail(String email);

    public List<Participant> findAll();

    public Participant update(Participant participant);

    public Participant save(Participant participant);

    public void deleteById(Long Id);

    public void deleteAll();
}
