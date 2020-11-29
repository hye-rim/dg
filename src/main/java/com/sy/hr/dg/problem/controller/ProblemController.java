package com.sy.hr.dg.problem.controller;

import com.sy.hr.dg.model.network.Header;


import com.sy.hr.dg.model.network.response.problem.ProblemResponse;

import com.sy.hr.dg.problem.service.ProblemService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/problem")
@RestController
@Slf4j
public class ProblemController {


    @Autowired
    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/{problemSeq}")
    public Header<ProblemResponse> readProblem(@PathVariable Long problemSeq) {
        /**
         * @description 문제상세조회
         * @method readProblem
         * @params [problemSeq] 문제번호
         * @return com.sy.hr.dg.model.network.Header<com.sy.hr.dg.model.network.response.problem.ProblemResponse>
         *
         * @author hr
         * @since 2020-11-29
         */
        return problemService.readProblem(problemSeq);
    }
}
