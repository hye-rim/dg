package com.sy.hr.dg.answer.repository;

import com.sy.hr.dg.answer.vo.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
