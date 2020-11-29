package com.sy.hr.dg.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReadForNicknameRequest {
    /**
     * @className UserReadForNicknameRequest
     * @description 닉네임 중복확인
     */

    private String nickname;

}
