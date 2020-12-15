package com.sy.hr.dg.answer.controller;

import com.sy.hr.dg.answer.response.AnswerResponse;
import com.sy.hr.dg.answer.service.AnswerService;
import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.answer.request.AnswerRegistRequest;
import com.sy.hr.dg.problem.response.ProblemResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/answer")
@RestController
@Slf4j
public class AnswerController {
    @Autowired
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public Header registAnswer(@RequestBody Header<AnswerRegistRequest> request ) {

        /**
         * @description 답안등록
         * @method registAnswer
         * @params [request]
         * @return com.sy.hr.dg.model.network.Header
         *
         * @author hr
         * @since 2020-12-15
         */
        log.info( "request => {}", request );
        return answerService.registAnswer( request );
    }

    @GetMapping("/{answerSeq}")
    public Header<AnswerResponse> readAnswer(@PathVariable Long answerSeq) {

        /**
         * @description 답안 상세 조회
         * @method readAnswer
         * @params [answerSeq] 조회 할 답안 번호
         * @return com.sy.hr.dg.model.network.Header<com.sy.hr.dg.problem.response.ProblemResponse>
         *
         * @author hr
         * @since 2020-12-15
         */
        return answerService.readAnswer(answerSeq);
    }
}
