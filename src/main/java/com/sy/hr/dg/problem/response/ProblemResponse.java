package com.sy.hr.dg.problem.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 문제 상세 조회
public class ProblemResponse {

    private Long problemSeq;

    private String languageCode;

    private String level;

    private String problemTitle;

    private String problemContents;

    private LocalDate regDate;

    private LocalDate updtDate;

    private String input;

    private String output;

}
