package com.sy.hr.dg.problem.controller;

import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.problem.request.ProblemReadRequest;
import com.sy.hr.dg.problem.response.ProblemResponse;
import com.sy.hr.dg.problem.service.ProblemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/problem")
@RestController
@Slf4j
public class ProblemController {

    @Autowired
    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @PostMapping
    public Header<ProblemResponse> readProblemList(@RequestBody Header<ProblemReadRequest> request ) {
        /**
         * @description 문제 목록 조회
         * @method readProblemList
         * @params [request]
         * @return com.sy.hr.dg.model.network.Header<com.sy.hr.dg.problem.response.ProblemResponse>
         *
         * @author sy
         * @since 2020-11-29
        */
        return problemService.readProblemList( request );
    }
}
