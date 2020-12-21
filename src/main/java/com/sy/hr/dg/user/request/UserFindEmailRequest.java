package com.sy.hr.dg.user.request;

import com.sy.hr.dg.email.vo.Email;
import com.sy.hr.dg.user.vo.User;
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

    private String userName;

    private String mobile;

}
