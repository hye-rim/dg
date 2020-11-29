package com.sy.hr.dg.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 회원 정보 조회 기능
public class UserReadForEmailResponse {

    private String userName;

    private String email;

    private String nickname;

    private String password;

    private String mobile;

    private String tryCount;

    private String successCount;

    private String deleteYn;

}
