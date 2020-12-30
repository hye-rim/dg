package com.sy.hr.dg.problem.request;

// 검색 조건에 따라 파라미터 값이 달라지기 때문에 유효성 검사를 할 수 없음!!
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 문제 목록 조회 기능
public class ProblemReadRequest {

    private String problemTitle;
    private String languageCode;
    private String level;
    private String nickname;
    private String userSeq;

}
