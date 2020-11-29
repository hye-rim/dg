package com.sy.hr.dg.user.reuest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFindEmailRequest {
    /**
     * @className UserFindEmailRequest
     * @description 이메일 찾기
     */

    private String name;

    private String mobile;

}
