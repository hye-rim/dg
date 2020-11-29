package com.sy.hr.dg.problem.service;

import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.model.network.response.problem.ProblemResponse;
import com.sy.hr.dg.problem.repository.ProblemRepository;
import com.sy.hr.dg.problem.vo.Problem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.sy.hr.dg.model.network.Header.OK;

@Service
@Slf4j
/**
 * @className ProblemService
 */
public class ProblemService {

    private final ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

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


