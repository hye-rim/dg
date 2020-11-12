package com.sy.hr.dg.model.network.response.answer;

import com.sy.hr.dg.common.vo.CodeVO;
import com.sy.hr.dg.problem.vo.Problem;
import com.sy.hr.dg.user.vo.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 답안 상세조회
public class AnswerResponse {

    private Long answerSeq;

    private String languageCode;

    private String email;

    private String answer;

    private LocalDate regDate;

    private LocalDate updtDate;

    private String successYn;

    private String openYn;

    private Long time;

    private Long memory;

}
