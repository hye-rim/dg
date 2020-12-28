package com.sy.hr.dg.answer.service;

import com.sy.hr.dg.answer.repository.AnswerRepository;
import com.sy.hr.dg.answer.request.AnswerListRequest;
import com.sy.hr.dg.answer.request.AnswerRegistRequest;
import com.sy.hr.dg.answer.response.AnswerListResponse;
import com.sy.hr.dg.answer.response.AnswerResponse;
import com.sy.hr.dg.answer.search.AnswerSearch;
import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.like.repository.LikeRepository;
import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.problem.repository.ProblemRepository;
import com.sy.hr.dg.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.sy.hr.dg.model.network.Header.OK;

@Service
@Slf4j
public class AnswerService {

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public Header registAnswer(Header<AnswerRegistRequest> request) {
        log.info( "registAnswer request => {}", request );

        AnswerRegistRequest answerRegistRequest = request.getData();

        Answer answer = Answer.builder()
                        .problem(problemRepository.getOne(answerRegistRequest.getProblemSeq()))
                        .user(userRepository.getOne(answerRegistRequest.getUserSeq()))
                        .languageCode(answerRegistRequest.getLanguageCode())
                        .answer(answerRegistRequest.getAnswer())
                        .successYn(answerRegistRequest.getSuccessYn())
                        .openYn(answerRegistRequest.getOpenYn())
                        .time(answerRegistRequest.getTime())
                        .memory(answerRegistRequest.getMemory())
                        .build();

        answerRepository.save( answer );

        return OK();
    }

    public Header<AnswerResponse> readAnswer(Long answerSeq) {
        log.info("readAnswer answerSeq => {}", answerSeq);

        //1 . 답안번호로 답안 조회
        //2.  답안 좋아요 갯수 조회
        //3.  내가 좋아요를 했는지
        return answerRepository.findByAnswerSeq( answerSeq )
                .map(answer -> {
                    AnswerResponse answerResponse = AnswerResponse.builder()
                        .userSeq(answer.getUser().getUserSeq())
                        .answerSeq(answer.getAnswerSeq())
                        .languageCode(answer.getLanguageCode())
                        .nickname( answer.getUser().getNickname() )
                        .answer(answer.getAnswer())
                        .memory(answer.getMemory())
                        .openYn(answer.getOpenYn())
                        .regDate(answer.getRegDate())
                        .successYn(answer.getSuccessYn())
                        .time(answer.getTime())
                        .updtDate(answer.getUpdtDate())
                        .totalLikeCnt( likeRepository.countByAnswer( answer ) )
                        .myLikeCnt( likeRepository.countByUserAndAnswer( answer.getUser(), answer ) )
                        .build();
                    return Header.OK(answerResponse);
                })
                .orElseGet(
                        ()->Header.ERROR("조회할 답안이 없습니다.")
                );
    }

    public Header deleteAnswer(Long answerSeq) {
        log.info("deleteAnswer answerSeq => {}", answerSeq);
        Optional<Answer> optional = answerRepository.findByAnswerSeq(answerSeq);
        return optional.map(answer ->{
            answerRepository.delete(answer);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("삭제할 답안이 없습니다."));
    }

    public Header<AnswerListResponse> readAnswerList(Header<AnswerListRequest> request) {
        AnswerListRequest answerListRequest = request.getData();

        List<Answer> answerList = answerRepository.findAll( AnswerSearch.answerSearchCondition( answerListRequest ) );

        List<AnswerResponse> answerResponseList = new ArrayList<>();

        Stream<Answer> answerStream = answerList.stream();
        answerStream.forEach( answer -> {
            AnswerResponse answerResponse = AnswerResponse.builder()
                                                            .answerSeq( answer.getAnswerSeq() )
                                                            .languageCode( answer.getLanguageCode() )
                                                            .nickname( answer.getUser().getNickname() )
                                                            .userSeq( answer.getUser().getUserSeq() )
                                                            .answer( answer.getAnswer() )
                                                            .regDate( answer.getRegDate() )
                                                            .updtDate( answer.getUpdtDate() )
                                                            .successYn( answer.getSuccessYn() )
                                                            .openYn( answer.getOpenYn() )
                                                            .time( answer.getTime() )
                                                            .memory( answer.getMemory() )
                                                            .totalLikeCnt( likeRepository.countByAnswer( answer ) )
                                                            .build();

            answerResponseList.add( answerResponse );
        });

        AnswerListResponse answerListResponse = AnswerListResponse.builder().answerList( answerResponseList ).build();

        return Header.OK( answerListResponse );
    }
}


