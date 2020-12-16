package com.sy.hr.dg.like.service;

import com.sy.hr.dg.answer.repository.AnswerRepository;
import com.sy.hr.dg.answer.request.AnswerRegistRequest;
import com.sy.hr.dg.answer.response.AnswerResponse;
import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.code.repository.CodeRepository;
import com.sy.hr.dg.like.repository.LikeRepository;
import com.sy.hr.dg.like.request.LikeAnswerRequest;
import com.sy.hr.dg.like.vo.LikeAnswer;
import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.problem.repository.ProblemRepository;
import com.sy.hr.dg.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.sy.hr.dg.model.network.Header.OK;

@Service
@Slf4j
/**
 * @className ProblemService
 */
public class LikeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnswerRepository answerRepository;


    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }


    public Header likeAnswer(Header<LikeAnswerRequest> request) {
        log.info( "request => {}", request );

        LikeAnswerRequest likeAnswerRequestRequest = request.getData();

        LikeAnswer likeAnswer = LikeAnswer.builder()
                .answer(answerRepository.getOne(likeAnswerRequestRequest.getAnswerSeq()))
                .user(userRepository.getOne(likeAnswerRequestRequest.getUserSeq()))
                .build();

        LikeAnswer newLikeAnswer = likeRepository.save( likeAnswer );


        return OK();
    }
}


