package com.sy.hr.dg.problem.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 문제 등록 기능
public class ProblemRegistRequest {

    private Long userSeq;

    private String level;

    private String problemTitle;

    private String problemContents;

    private String input;

    private String output;

}
