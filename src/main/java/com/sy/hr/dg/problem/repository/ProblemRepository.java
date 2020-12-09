package com.sy.hr.dg.problem.repository;

import com.sy.hr.dg.problem.vo.Problem;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long>, JpaSpecificationExecutor<Problem> {

    Problem findByProblemSeq(Long problemSeq);

}
