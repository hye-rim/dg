package com.sy.hr.dg.model.network.request.like;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 좋아요/좋아요 취소 기능
// email이 없는 이유는 세션에서 가져와야 함
public class LikeRequest {

    private Long answerSeq;

}
