package com.sy.hr.dg.problem.service;

import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.problem.request.ProblemReadRequest;
import com.sy.hr.dg.problem.response.ProblemListResponse;
import com.sy.hr.dg.problem.response.ProblemResponse;
import com.sy.hr.dg.problem.repository.ProblemRepository;
import com.sy.hr.dg.problem.vo.Problem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    public Header<ProblemResponse> readProblemList(Header<ProblemReadRequest> request) {

        ProblemReadRequest problemReadRequest = request.getData();

        log.info( "request -> {}", problemReadRequest );

        List<Problem> problem = problemRepository.findAll(
                new Specification<Problem>() {
                    @Override
                    public Predicate toPredicate(Root<Problem> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                        List<Predicate> predicates = new ArrayList<>();

                        if( !StringUtils.isEmpty( problemReadRequest.getProblemTitle() ) )
                            predicates.add( criteriaBuilder.like( root.get("problemTitle"), "%" + problemReadRequest.getProblemTitle() + "%" ) );

                        if( !StringUtils.isEmpty( problemReadRequest.getLanguageCode() ) )
                            predicates.add( criteriaBuilder.like( root.get("languageCode"), "%" + problemReadRequest.getLanguageCode() + "%" ) );

                        if( !StringUtils.isEmpty( problemReadRequest.getLevel() ) )
                            predicates.add( criteriaBuilder.like( root.get("level"), "%" + problemReadRequest.getLevel() + "%" ) );

                        if( !StringUtils.isEmpty( problemReadRequest.getNickname() ) )
                            predicates.add( criteriaBuilder.like( root.get("nickname"), "%" + problemReadRequest.getNickname() + "%" ) );

                        return criteriaBuilder.and( predicates.toArray( new Predicate[ predicates.size() ] ) );
                    }
                }
        );

        log.info( "problemList -> {}", problem );

        Stream<Problem> problemStream = problem.stream();
        problemStream.forEach( p -> log.info( p.getProblemContents() ) );

        /*ProblemListResponse problemListResponse =*/

        return Header.OK();
    }
}
