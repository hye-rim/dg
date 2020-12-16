package com.sy.hr.dg.like.controller;

import com.sy.hr.dg.answer.request.AnswerRegistRequest;
import com.sy.hr.dg.answer.service.AnswerService;
import com.sy.hr.dg.like.request.LikeAnswerRequest;
import com.sy.hr.dg.like.service.LikeService;
import com.sy.hr.dg.model.network.Header;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/like")
@RestController
@Slf4j
public class LikeController {
    @Autowired
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public Header likeAnswer(@RequestBody Header<LikeAnswerRequest> request ) {

        log.info( "likeAnswer request => {}", request );
        return likeService.likeAnswer(request);
    }

}
