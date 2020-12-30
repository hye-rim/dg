package com.sy.hr.dg.user.request;

import com.sy.hr.dg.user.vo.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistRequest {
    /**
     * @className UserRegistRequest
     * @description 회원 등록 Request
     */

    private String userName;
    private String email;
    private String nickname;
    private String password;
    private String mobile;

    public User getUser() {
        return User.builder()
                   .userName( userName )
                   .email( email )
                   .nickname( nickname )
                   .password( password )
                   .mobile( mobile )
                   .build();
    }
}
