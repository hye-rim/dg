package com.sy.hr.dg.code.repository;

import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.code.vo.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends JpaRepository<Code, String> {

}
