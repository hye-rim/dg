package com.sy.hr.dg.problem.service;

import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.model.network.response.problem.ProblemResponse;
import com.sy.hr.dg.problem.repository.ProblemRepository;
import com.sy.hr.dg.problem.vo.Problem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.sy.hr.dg.model.network.Header.OK;

@Service
@Slf4j
/**
 * @className ProblemService
 */
public class ProblemService {

    private final ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public Header<ProblemResponse> readProblem(Long problemSeq ) {

        log.info("readProblem problemSeq => {}", problemSeq);
        Problem problem = problemRepository.findByProblemSeq( problemSeq );
        ProblemResponse problemResponse = ProblemResponse.builder()
                .problemContents(problem.getProblemContents())
                .problemSeq(problem.getProblemSeq())
                .problemTitle(problem.getProblemTitle())
                .input(problem.getInput())
                .level(problem.getLevel())
                .output(problem.getOutput())
                .regDate(problem.getRegDate())
                .updtDate(problem.getUpdtDate())
                .userSeq(problem.getUser().getUserSeq())
                .build();
        return Header.OK(problemResponse);
    }


}


