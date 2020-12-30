package com.sy.hr.dg.answer.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerRegistRequest {

    private Long problemSeq;
    private String languageCode;
    private Long userSeq;
    private String answer;
    private String successYn;
    private String openYn;
    private Long time;
    private Long memory;

}
