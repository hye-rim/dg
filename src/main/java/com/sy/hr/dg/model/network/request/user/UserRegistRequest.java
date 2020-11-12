package com.sy.hr.dg.model.network.request.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 회원 정보 등록 기능
public class UserRegistRequest {

    private String userName;

    private String email;

    private String nickname;

    private String password;

    private String mobile;
}
