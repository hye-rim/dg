package com.sy.hr.dg.problem.repository;

import com.sy.hr.dg.model.network.response.problem.ProblemResponse;
import com.sy.hr.dg.problem.vo.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {

    Problem findByProblemSeq(Long problemSeq);


}
