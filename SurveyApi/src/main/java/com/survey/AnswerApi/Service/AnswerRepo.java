package com.survey.AnswerApi.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.survey.AnswerApi.Model.Answer;

import java.util.Set;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Long> {

    Answer findByAnswerIdAndAndQuestionIdAndAndSurveyId(String answerId, long questionId, long surveyId);

    Set<Answer> findAllByQuestionId(long questionId);
}
