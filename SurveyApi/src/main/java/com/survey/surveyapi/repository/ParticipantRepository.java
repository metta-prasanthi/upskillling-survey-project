package com.survey.surveyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.surveyapi.entity.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    public Participant findByFirstName(String name);
    public Participant findByEmail(String email);
    public void deleteById(Long id);
}