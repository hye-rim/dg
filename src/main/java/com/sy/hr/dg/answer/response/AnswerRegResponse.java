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
// 답안 등록
public class AnswerRegResponse {

    private String code;

    private String answer;

    private String successYn;

    private String openYn;

    private Long time;

    private Long memory;

    private Long problemSeq;

    private Long userSeq;

}
