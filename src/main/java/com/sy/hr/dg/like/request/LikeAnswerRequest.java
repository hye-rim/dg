package com.sy.hr.dg.like.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikeAnswerRequest {
    private Long answerSeq;
    private Long userSeq;
}
