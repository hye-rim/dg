package com.sy.hr.dg.problem.search;

import com.sy.hr.dg.problem.request.ProblemReadRequest;
import com.sy.hr.dg.problem.vo.Problem;
import com.sy.hr.dg.user.vo.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @className ProblemSearch
 * @description 문제 목록 조회 검색 조건
 */
public class ProblemSearch {

    public static Specification<Problem> problemSearchCondition( ProblemReadRequest problemReadRequest ) {

        return (Specification<Problem>) ( (root, query, criteriaBuilder) -> {
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

            return criteriaBuilder.and( predicates.toArray( new Predicate[ predicates.size() ] ) );
        });
    }
}
