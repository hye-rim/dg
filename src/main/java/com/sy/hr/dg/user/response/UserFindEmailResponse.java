package com.sy.hr.dg.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFindEmailResponse {
    /**
     * @className UserFindEmailResponse
     * @description 이메일 찾기 기능
     */

    private String email;

}
