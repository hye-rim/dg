package com.sy.hr.dg.answer.service;

import com.sy.hr.dg.answer.repository.AnswerRepository;
import com.sy.hr.dg.answer.request.AnswerListRequest;
import com.sy.hr.dg.answer.request.AnswerRegistRequest;
import com.sy.hr.dg.answer.response.AnswerListResponse;
import com.sy.hr.dg.answer.response.AnswerResponse;
import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.code.repository.CodeRepository;
import com.sy.hr.dg.like.repository.LikeRepository;
import com.sy.hr.dg.like.vo.LikeAnswer;
import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.problem.repository.ProblemRepository;
import com.sy.hr.dg.problem.response.ProblemResponse;
import com.sy.hr.dg.problem.vo.Problem;
import com.sy.hr.dg.user.repository.UserRepository;
import com.sy.hr.dg.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.sy.hr.dg.model.network.Header.OK;

@Service
@Slf4j
/**
 * @className AnswerService
 */
public class AnswerService {

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private CodeRepository codeRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public Header registAnswer(Header<AnswerRegistRequest> request) {
        log.info( "request => {}", request );

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

        Answer newAnswer = answerRepository.save( answer );


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
                        .email(answer.getUser().getEmail())
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
                        ()->Header.ERROR("No Data")
                );
    }

    public Header deleteAnswer(Long answerSeq) {
        Optional<Answer> optional = answerRepository.findByAnswerSeq(answerSeq);
        return optional.map(answer ->{
            answerRepository.delete(answer);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("No Data"));
    }

    public Header<AnswerListResponse> readAnswerList(Header<AnswerListRequest> request) {
        AnswerListRequest answerListRequest = request.getData();

        List<Answer> answerList = answerRepository.findAll(
            new Specification<Answer>() {
                @Override
                public Predicate toPredicate(Root<Answer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicates = new ArrayList<>();
                    Join<User, Answer> userAnswerJoin = root.join("user");
                    Join<Problem, Answer> problemAnswerJoin = root.join("problem");

                    if( !StringUtils.isEmpty( answerListRequest.getProblemSeq() ) )
                        predicates.add( criteriaBuilder.equal( problemAnswerJoin.get("problemSeq"), answerListRequest.getProblemSeq() ) );
                        //predicates.add( criteriaBuilder.like( root.get("problemSeq"), "%" + answerListRequest.getProblemSeq() + "%" ) );

                    if( !StringUtils.isEmpty( answerListRequest.getLanguageCode() ) )
                        predicates.add( criteriaBuilder.like( root.get("languageCode"), "%" + answerListRequest.getLanguageCode() + "%" ) );

                    if( !StringUtils.isEmpty( answerListRequest.getUserSeq() ) )
                        predicates.add( criteriaBuilder.equal( userAnswerJoin.get("userSeq"), answerListRequest.getUserSeq() ) );
                        //predicates.add( criteriaBuilder.like( root.get("userSeq"), "%" + answerListRequest.getUserSeq() + "%" ) );

                    if( !StringUtils.isEmpty( answerListRequest.getSuccessYn() ) )
                        predicates.add( criteriaBuilder.like( root.get("successYn"), "%" + answerListRequest.getSuccessYn() + "%" ) );

                    return criteriaBuilder.and( predicates.toArray( new Predicate[ predicates.size() ] ) );
                }
            });

        List<AnswerResponse> answerResponseList = new ArrayList<>();

        Stream<Answer> answerStream = answerList.stream();
        answerStream.forEach( ( p ) -> {
            AnswerResponse answerResponse = AnswerResponse.builder()
                                                            .answerSeq( p.getAnswerSeq() )
                                                            .languageCode( p.getLanguageCode() )
                                                            .answer( p.getAnswer() )
                                                            .regDate( p.getRegDate() )
                                                            .updtDate( p.getUpdtDate() )
                                                            .successYn( p.getSuccessYn() )
                                                            .openYn( p.getOpenYn() )
                                                            .time( p.getTime() )
                                                            .memory( p.getMemory() )
                                                            .build();

            answerResponseList.add( answerResponse );
        });

        AnswerListResponse answerListResponse = AnswerListResponse.builder().answerList( answerResponseList ).build();

        return Header.OK( answerListResponse );
    }
}


