package com.sy.hr.dg.model.network.request.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModifyPasswordRequest {
    /**
     * @className UserModifyPasswordRequest
     * @description 비밀번호 변경
     */

    private String email;

    private String password;

}
