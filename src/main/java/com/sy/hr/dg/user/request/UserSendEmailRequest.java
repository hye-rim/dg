package com.sy.hr.dg.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSendEmailRequest {
    /**
     * @className UserSendEmailRequest
     * @description 이메일 전송 Request
     */

    private String userName;

    private String email;

}
