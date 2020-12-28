package com.sy.hr.dg.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthResponse {
    /**
     * @className UserAuthResponse
     * @description 회원 인증
     */

    private Long userSeq;
    private String authYn;

}
