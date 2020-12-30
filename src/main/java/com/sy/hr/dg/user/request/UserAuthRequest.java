package com.sy.hr.dg.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthRequest {
    /**
     * @className UserAuthRequest
     * @description 회원 인증
     */
    
    private Long userSeq;
    private String authCode;
    private String sendYn;

}
