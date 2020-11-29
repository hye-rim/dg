package com.sy.hr.dg.user.reuest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModifyRequest {
    /**
     * @className UserModifyRequest
     * @description 회원 정보 수정
     */

    private Long userSeq;

    private String password;

    private String mobile;
}