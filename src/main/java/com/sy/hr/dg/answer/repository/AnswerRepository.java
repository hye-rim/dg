package com.sy.hr.dg.answer.repository;

import com.sy.hr.dg.answer.vo.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Optional<Answer> findByAnswerSeq(Long answerSeq);

    //Answer findByAnswerSeq(Long answerSeq);
}
