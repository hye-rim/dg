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
     * @className UserUpdateRequest
     * @description 회원 수정 관련
     */

    private Long userSeq;
    private String userName;
    private String email;
    private String nickname;
    private String password;
    private String mobile;
    private Integer tryCount;
    private Integer successCount;
    private String deleteYn;

    public User getUser() {
        return User.builder()
                .userSeq( userSeq )
                .userName( userName )
                .email( email )
                .nickname( nickname )
                .password( password )
                .mobile( mobile )
                .tryCount( tryCount )
                .successCount( successCount )
                .deleteYn( deleteYn )
                .build();
    }
}
