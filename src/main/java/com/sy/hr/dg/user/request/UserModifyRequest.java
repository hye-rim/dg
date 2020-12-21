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
public class UserModifyRequest {
    /**
     * @className UserModifyRequest
     * @description 회원 정보 수정
     */

    private Long userSeq;

    private String password;

    private String mobile;

    public User getUser() {
        return User.builder()
                .userSeq( userSeq )
                .password( password )
                .mobile( mobile )
                .build();
    }

}