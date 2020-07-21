package com.survey.surveyapi.service;

import java.util.List;

import com.survey.surveyapi.entity.Participant;

public interface ParticipantService {	

    public Participant findByName(String name);

    public Participant findByEmail(String email);

    public List<Participant> findAll();

    public Participant update(Participant participant);

    public Participant save(Participant participant);

    public void deleteById(Long Id);

    public void deleteAll();
}
