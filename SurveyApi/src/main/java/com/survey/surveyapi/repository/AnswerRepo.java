package com.survey.surveyapi.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.surveyapi.entity.Answer;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Long> {

    Answer findByAnswerIdAndAndQuestionIdAndAndSurveyId(String answerId, long questionId, long surveyId);

    Set<Answer> findAllByQuestionId(long questionId);
}
