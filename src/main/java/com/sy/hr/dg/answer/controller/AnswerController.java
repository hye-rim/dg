package com.sy.hr.dg.answer.controller;

import com.sy.hr.dg.answer.request.AnswerListRequest;
import com.sy.hr.dg.answer.request.AnswerRegistRequest;
import com.sy.hr.dg.answer.response.AnswerListResponse;
import com.sy.hr.dg.answer.response.AnswerResponse;
import com.sy.hr.dg.answer.service.AnswerService;
import com.sy.hr.dg.model.network.Header;
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

    @PostMapping("/list")
    public Header<AnswerListResponse> readAnswerList( @RequestBody Header<AnswerListRequest> request ) {
        /**
         * @description 답안 목록 조회
         * @method readAnswerList
         * @params [request]
         * @return com.sy.hr.dg.model.network.Header<com.sy.hr.dg.answer.response.AnswerListResponse>
         *
         * @author sy
         * @since 2020-12-16
        */
        return answerService.readAnswerList( request );
    }

    @PostMapping
    public Header registAnswer(@RequestBody Header<AnswerRegistRequest> request ) {

        /**
         * @description 답안 등록
         * @method registAnswer
         * @params [request]
         * @return com.sy.hr.dg.model.network.Header
         *
         * @author hr
         * @since 2020-12-15
         */
        log.info( "registAnswer request => {}", request );
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

    @DeleteMapping("{answerSeq}")
    public Header deleteAnswer(@PathVariable Long answerSeq) {
       /**
        * @description 답안 삭제
        * @method deleteAnswer
        * @params [answerSeq] 삭제할 답안 번호
        * @return com.sy.hr.dg.model.network.Header
        *
        * @author hr
        * @since 2020-12-16
        */
        return answerService.deleteAnswer(answerSeq);
    }
}
