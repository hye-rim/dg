package com.sy.hr.dg.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 이메일 중복 확인, 닉네임 중복 확인
public class UserDoubleCheckResponse {

    private String duplicateYn;

}
