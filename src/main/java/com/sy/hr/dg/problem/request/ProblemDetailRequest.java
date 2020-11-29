package com.sy.hr.dg.problem.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 문제 상세 조회 기능
public class ProblemDetailRequest {

    private Long problemSeq;

}
