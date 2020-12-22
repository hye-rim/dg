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
public class UserSendEmailRequest {
    /**
     * @className UserSendEmailRequest
     * @description 이메일 전송 Request
     */

    private String userName;

    private String email;

    public Email sendEmailInfo(String sendYn, String fromEmail, String title, String content, User user ) {
        return  Email.builder()
                .sendYn( sendYn )
                .title( title )
                .contents( content )
                .receiver( email )
                .sender( fromEmail )
                .user( user )
                .build();
    }
}
