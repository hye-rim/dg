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
public class UserModifyPasswordRequest {
    /**
     * @className UserModifyPasswordRequest
     * @description 비밀번호 변경
     */

    private Long userSeq;
    private String password;

    public User getUser() {
        return User.builder()
                .userSeq( userSeq )
                .password( password )
                .build();
    }

}
