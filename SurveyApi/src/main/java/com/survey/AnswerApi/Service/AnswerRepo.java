package com.survey.AnswerApi.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.survey.AnswerApi.Model.Answer;

import java.util.Set;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Long> {

//    Answer findByAnswerId(long id);

    Set<Answer> findAllByQuestionId(long questionId);
}
