package com.sy.hr.dg.answer.search;

import com.sy.hr.dg.answer.request.AnswerListRequest;
import com.sy.hr.dg.answer.request.AnswerReadRequest;
import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.problem.vo.Problem;
import com.sy.hr.dg.user.vo.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @className AnswerSearch
 * @description 답안 목록 조회 검색 조건
 */
public class AnswerSearch {

    public static Specification<Answer> answerSearchCondition( AnswerListRequest answerListRequest ) {
        return (Specification<Answer>) ( (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            Join<User, Answer> userAnswerJoin = root.join("user");
            Join<Problem, Answer> problemAnswerJoin = root.join("problem");

            if( !StringUtils.isEmpty( answerListRequest.getProblemSeq() ) )
                predicates.add( criteriaBuilder.equal( problemAnswerJoin.get("problemSeq"), answerListRequest.getProblemSeq() ) );

            if( !StringUtils.isEmpty( answerListRequest.getLanguageCode() ) )
                predicates.add( criteriaBuilder.like( root.get("languageCode"), "%" + answerListRequest.getLanguageCode() + "%" ) );

            if( !StringUtils.isEmpty( answerListRequest.getUserSeq() ) )
                predicates.add( criteriaBuilder.equal( userAnswerJoin.get("userSeq"), answerListRequest.getUserSeq() ) );

            if( !StringUtils.isEmpty( answerListRequest.getSuccessYn() ) )
                predicates.add( criteriaBuilder.like( root.get("successYn"), "%" + answerListRequest.getSuccessYn() + "%" ) );

            return criteriaBuilder.and( predicates.toArray( new Predicate[ predicates.size() ] ) );
        });
    }
}
