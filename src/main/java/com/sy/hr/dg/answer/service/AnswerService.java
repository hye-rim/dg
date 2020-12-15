package com.sy.hr.dg.answer.service;

import com.sy.hr.dg.answer.repository.AnswerRepository;
import com.sy.hr.dg.answer.response.AnswerRegResponse;
import com.sy.hr.dg.answer.response.AnswerResponse;
import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.code.repository.CodeRepository;
import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.answer.request.AnswerRegistRequest;
import com.sy.hr.dg.problem.repository.ProblemRepository;
import com.sy.hr.dg.problem.response.ProblemResponse;
import com.sy.hr.dg.problem.vo.Problem;
import com.sy.hr.dg.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.sy.hr.dg.model.network.Header.OK;

@Service
@Slf4j
/**
 * @className ProblemService
 */
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CodeRepository codeRepository;


    public AnswerService(AnswerRepository aswerRepository) {
        this.answerRepository = aswerRepository;
    }


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
        Answer answer = answerRepository.findByAnswerSeq( answerSeq );
        AnswerResponse answerResponse = AnswerResponse.builder()
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
                .build();
        return Header.OK(answerResponse);
    }
}


