package com.sy.hr.dg.model.network.request.answer;

// 검색 조건에 따라 파라미터 값이 달라지기 때문에 유효성 검사를 할 수 없음!!
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerReadRequest {

    private String problemSeq;

    private String languageCode;

    private String userSeq;

    private String successYn;

}
