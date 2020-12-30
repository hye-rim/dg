package com.sy.hr.dg.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDoubleCheckResponse {
    /**
     * @className UserDoubleCheckResponse
     * @description 이메일 중복 확인, 닉네임 중복 확인
     */

    private String duplicateYn;

}
