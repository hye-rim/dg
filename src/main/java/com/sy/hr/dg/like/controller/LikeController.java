package com.sy.hr.dg.like.controller;

import com.sy.hr.dg.like.request.LikeAnswerRequest;
import com.sy.hr.dg.like.service.LikeService;
import com.sy.hr.dg.model.network.Header;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        /**
         * @description 답안 좋아요
         * @method likeAnswer
         * @params [request] 좋아요 할 답안 번호와 좋아요하는 호원번호
         * @return com.sy.hr.dg.model.network.Header
         *
         * @author hr
         * @since 2020-12-16
         */
        log.info( "likeAnswer request => {}", request );
        return likeService.likeAnswer(request);
    }


    @DeleteMapping("{likeSeq}")
    public Header hateAnser(@PathVariable Long likeSeq) {
        /**
         * @description 좋아요 취소
         * @method hateAnser
         * @params [likeSeq]
         * @return com.sy.hr.dg.model.network.Header
         *
         * @author hr
         * @since 2020-12-19
         */
        return likeService.hateAnser(likeSeq);
    }



}
