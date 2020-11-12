package com.sy.hr.dg.model.network.request.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 회원 탈퇴, 이메일 중복확인, 회원 정보 조회 기능
public class UserReadForEmailRequest {

    private String email;

}
