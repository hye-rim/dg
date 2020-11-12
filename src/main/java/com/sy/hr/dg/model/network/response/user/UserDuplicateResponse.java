package com.sy.hr.dg.model.network.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 닉네임, 이메일 중복 확인 기능
public class UserDuplicateResponse {

    private String duplicateYn;

}
