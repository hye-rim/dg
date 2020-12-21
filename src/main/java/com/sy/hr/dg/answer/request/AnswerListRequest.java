package com.sy.hr.dg.answer.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerListRequest {

    private Long problemSeq;
    private Long userSeq;
    private String languageCode;
    private String successYn;

}
