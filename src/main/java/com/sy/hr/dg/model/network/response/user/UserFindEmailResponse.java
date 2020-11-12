package com.sy.hr.dg.model.network.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 이메일 찾기 기능
public class UserFindEmailResponse {

    private String email;

}
