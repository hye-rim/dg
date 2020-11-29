package com.sy.hr.dg.answer.controller;

import com.sy.hr.dg.answer.service.AnswerService;
import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.answer.request.AnswerRegistRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        log.info( "request => {}", request );


        return answerService.registAnswer( request );
    }
}
