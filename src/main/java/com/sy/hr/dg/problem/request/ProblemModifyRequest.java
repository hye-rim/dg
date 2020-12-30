package com.sy.hr.dg.problem.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 문제 수정
public class ProblemModifyRequest {

    private Long problemSeq;
    private Long userSeq;
    private String level;
    private String problemTitle;
    private String problemContents;
    private String input;
    private String output;

}
