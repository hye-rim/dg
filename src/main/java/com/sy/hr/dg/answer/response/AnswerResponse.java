package com.sy.hr.dg.answer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
