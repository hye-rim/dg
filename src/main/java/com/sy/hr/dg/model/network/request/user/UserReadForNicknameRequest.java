package com.sy.hr.dg.model.network.request.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 닉네임 중복확인 기능
public class UserReadForNicknameRequest {

    private String nickname;

}
