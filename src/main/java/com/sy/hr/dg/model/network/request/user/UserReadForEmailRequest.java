package com.sy.hr.dg.model.network.request.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReadForEmailRequest {
    /**
     * @className UserReadForEmailRequest
     * @description 이메일 중복확인
     */

    private String email;

}
