package com.sy.hr.dg.answer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    private LocalDateTime regDate;

    private LocalDateTime updtDate;

    private String successYn;

    private String openYn;

    private Long time;

    private Long memory;

    private Long userSeq;

    private Long totalLikeCnt;

    private Long myLikeCnt;

}
