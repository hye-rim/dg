package com.sy.hr.dg.user.reuest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistRequest {
    /**
     * @className UserRegistRequest
     * @description 회원 정보 등록
     */

    private String userName;

    private String email;

    private String nickname;

    private String password;

    private String mobile;
}
