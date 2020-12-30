package com.sy.hr.dg.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSendEmailResponse {
    /**
     * @className UserSendEmailResponse
     * @description 이메일 인증 메일 발송
     */

    private String sendYn;
    private Long userSeq;

}
