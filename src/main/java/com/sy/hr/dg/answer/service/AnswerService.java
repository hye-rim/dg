package com.sy.hr.dg.answer.service;

import com.sy.hr.dg.answer.repository.AnswerRepository;
import com.sy.hr.dg.answer.response.AnswerRegResponse;
import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.code.repository.CodeRepository;
import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.answer.request.AnswerRegistRequest;
import com.sy.hr.dg.problem.repository.ProblemRepository;
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

    private final AnswerRepository aswerRepository;

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CodeRepository codeRepository;


    public AnswerService(AnswerRepository aswerRepository) {
        this.aswerRepository = aswerRepository;
    }


    public Header registAnswer(Header<AnswerRegistRequest> request) {
        log.info( "request => {}", request );

        AnswerRegistRequest answerRegistRequest = request.getData();

        Answer answer = Answer.builder()
                .problem(problemRepository.getOne(answerRegistRequest.getProblemSeq()))
                .user(userRepository.getOne(answerRegistRequest.getUserSeq()))
//                .problemSeq(answerRegistRequest.getProblemSeq())
//                .userSeq(answerRegistRequest.getUserSeq())
                .languageCode(answerRegistRequest.getLanguageCode())
                .answer(answerRegistRequest.getAnswer())
                .successYn(answerRegistRequest.getSuccessYn())
                .openYn(answerRegistRequest.getOpenYn())
                .time(answerRegistRequest.getTime())
                .memory(answerRegistRequest.getMemory())
                .build();

        Answer newAnswer = aswerRepository.save( answer );

//        AnswerRegResponse body = AnswerRegResponse.builder()
//                .problemSeq(newAnswer.getProblem().getProblemSeq())
//                .userSeq(newAnswer.getUser().getUserSeq())
//                .code(newAnswer.getCode())
//                .answer(newAnswer.getAnswer())
//                .successYn(newAnswer.getSuccessYn())
//                .openYn(newAnswer.getOpenYn())
//                .time(newAnswer.getTime())
//                .memory(newAnswer.getMemory())
//                .build();

        return OK();
    }
}


