package com.sy.hr.dg.answer.repository;

import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.user.vo.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>, JpaSpecificationExecutor<Answer> {
    Optional<Answer> findByAnswerSeq(Long answerSeq);
}
