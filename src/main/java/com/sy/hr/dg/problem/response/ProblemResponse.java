package com.sy.hr.dg.problem.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.sy.hr.dg.problem.vo.Problem;
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

    private LocalDateTime regDate;

    private LocalDateTime updtDate;

    private String input;

    private String output;

    private String status;

}
