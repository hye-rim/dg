package com.sy.hr.dg.user.response;

import com.sy.hr.dg.user.vo.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReadForEmailResponse {
    /**
     * @className UserReadForEmailResponse
     * @description 회원 정보 조회 기능
     */

    private String userName;
    private String email;
    private String nickname;
    private String password;
    private String mobile;
    private Integer tryCount;
    private Integer successCount;
    private String deleteYn;

}
