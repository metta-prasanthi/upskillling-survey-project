package com.survey.SurveyApi.repository.Participant;

import com.survey.SurveyApi.entity.participant.Participant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    public Participant findByName(String name);
    public Participant findByEmail(String email);
    public void deleteById(Long id);
}