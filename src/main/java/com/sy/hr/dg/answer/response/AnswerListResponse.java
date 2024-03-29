package com.sy.hr.dg.answer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 답안 목록 조회
public class AnswerListResponse {

    private List<AnswerResponse> answerList;

}
