package com.sy.hr.dg.user.reuest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginRequest {
    /**
     * @className UserLoginRequest
     * @description 로그인
     */

    private String email;

    private String password;

}
