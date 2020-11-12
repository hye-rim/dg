package com.sy.hr.dg.model.network.response.problem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 문제 목록 조회
public class ProblemListResponse {

    private List<ProblemResponse> problemList;

}
