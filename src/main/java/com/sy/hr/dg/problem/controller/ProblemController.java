package com.sy.hr.dg.problem.controller;

import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.problem.request.ProblemModifyRequest;
import com.sy.hr.dg.problem.request.ProblemReadRequest;
import com.sy.hr.dg.problem.request.ProblemRegistRequest;
import com.sy.hr.dg.problem.response.ProblemListResponse;
import com.sy.hr.dg.problem.response.ProblemResponse;
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
         * @description 문제 상세 조회
         * @method readProblem
         * @params [problemSeq] 문제 번호
         * @return com.sy.hr.dg.model.network.Header<com.sy.hr.dg.model.network.response.problem.ProblemResponse>
         *
         * @author hr
         * @since 2020-11-29
         */
        return problemService.readProblem(problemSeq);
    }

    @PostMapping("/list")
    public Header<ProblemListResponse> readProblemList(@RequestBody Header<ProblemReadRequest> request ) {
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

    @PutMapping
    public Header modifyProblem (@RequestBody Header<ProblemModifyRequest> request){
        /**
         * @description 문제 수정
         * @method modifyProblem
         * @params [request]
         * @return com.sy.hr.dg.model.network.Header
         *
         * @author hr
         * @since 2020-12-28
         */
        return problemService.modifyProblem( request );
    }

    @PostMapping
    public Header registProblem (@RequestBody Header<ProblemRegistRequest> request){
        /**
         * @description 문제 등록
         * @method registProblem
         * @params [request]
         * @return com.sy.hr.dg.model.network.Header
         *
         * @author hr
         * @since 2020-12-28
         */
        return problemService.registProblem( request );
    }
}
