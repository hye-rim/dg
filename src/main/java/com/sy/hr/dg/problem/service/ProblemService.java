package com.sy.hr.dg.problem.service;

import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.problem.repository.ProblemRepository;
import com.sy.hr.dg.problem.request.ProblemReadRequest;
import com.sy.hr.dg.problem.response.ProblemListResponse;
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
import java.util.stream.Stream;

@Service
@Slf4j
/**
 * @className ProblemService
 */
public class ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private UserRepository userRepository;

    public Header<ProblemResponse> readProblem(Long problemSeq ) {

        log.info("readProblem problemSeq => {}", problemSeq);
        Problem problem = problemRepository.findByProblemSeq( problemSeq );
        ProblemResponse problemResponse = ProblemResponse.builder()
                .problemContents(problem.getProblemContents())
                .problemSeq(problem.getProblemSeq())
                .problemTitle(problem.getProblemTitle())
                .input(problem.getInput())
                .level(problem.getLevel())
                .output(problem.getOutput())
                .regDate(problem.getRegDate())
                .updtDate(problem.getUpdtDate())
                .userSeq(problem.getUser().getUserSeq())
                .build();
        return Header.OK(problemResponse);
    }

    public Header<ProblemListResponse> readProblemList(Header<ProblemReadRequest> request) {

        ProblemReadRequest problemReadRequest = request.getData();

        log.info( "request -> {}", problemReadRequest );

        List<Problem> problem = problemRepository.findAll(
                new Specification<Problem>() {
                    @Override
                    public Predicate toPredicate(Root<Problem> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                        List<Predicate> predicates = new ArrayList<>();
                        Join<User, Problem> userProblemJoin = root.join("user");

                        if( !StringUtils.isEmpty( problemReadRequest.getProblemTitle() ) )
                            predicates.add( criteriaBuilder.like( root.get("problemTitle"), "%" + problemReadRequest.getProblemTitle() + "%" ) );

                        if( !StringUtils.isEmpty( problemReadRequest.getLanguageCode() ) )
                            predicates.add( criteriaBuilder.like( root.get("languageCode"), "%" + problemReadRequest.getLanguageCode() + "%" ) );

                        if( !StringUtils.isEmpty( problemReadRequest.getLevel() ) )
                            predicates.add( criteriaBuilder.like( root.get("level"), "%" + problemReadRequest.getLevel() + "%" ) );

                        if( !StringUtils.isEmpty( problemReadRequest.getNickname() ) )
                            predicates.add( criteriaBuilder.like( root.get("nickname"), "%" + problemReadRequest.getNickname() + "%" ) );

                        if( !StringUtils.isEmpty( problemReadRequest.getUserSeq() ) )
                            predicates.add( criteriaBuilder.equal( userProblemJoin.get("userSeq"), problemReadRequest.getUserSeq() ) );
                            //predicates.add( criteriaBuilder.and( userProblemJoin.get("userSeq"), problemReadRequest.getUserSeq() ) );

                        return criteriaBuilder.and( predicates.toArray( new Predicate[ predicates.size() ] ) );
                    }
                }
        );

        List<ProblemResponse> problemList = new ArrayList<>();

        Stream<Problem> problemStream = problem.stream();
        problemStream.forEach( ( p ) -> {
            ProblemResponse problemResponse = ProblemResponse.builder()
                                                            .problemSeq( p.getProblemSeq() )
                                                            .userSeq( p.getUser().getUserSeq() )
                                                            .level( p.getLevel() )
                                                            .problemTitle( p.getProblemTitle() )
                                                            .problemContents( p.getProblemContents() )
                                                            .regDate( p.getRegDate() )
                                                            .updtDate( p.getUpdtDate() )
                                                            .input( p.getInput() )
                                                            .output( p.getOutput() )
                                                            .status( p.getStatus() )
                                                            .build();

            problemList.add( problemResponse );

            log.info( "problemResponse -> {}", problemResponse );
        });

        ProblemListResponse problemListResponse = ProblemListResponse.builder().problemList( problemList ).build();

        log.info( "problemListResponse -> {}", problemListResponse );

        return Header.OK( problemListResponse );
    }

}


