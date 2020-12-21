package com.sy.hr.dg.user.request;

import com.sy.hr.dg.email.vo.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthRequest {
    
    private Long userSeq;

    private String email;

    private String authCode;

}
