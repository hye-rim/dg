package com.sy.hr.dg.model.network.request.answer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerRegistRequest {

    private String problemSeq;

    private String languageCode;

    private String userSeq;

    private String answer;

    private String successYn;

    private String openYn;

    private String time;

    private String memory;

}
