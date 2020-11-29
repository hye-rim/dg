package com.sy.hr.dg.model.network.response.problem;

import java.time.LocalDate;

import com.sy.hr.dg.user.vo.User;
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

    private Long userSeq;

    private String level;

    private String problemTitle;

    private String problemContents;

    private LocalDate regDate;

    private LocalDate updtDate;

    private String input;

    private String output;

}
