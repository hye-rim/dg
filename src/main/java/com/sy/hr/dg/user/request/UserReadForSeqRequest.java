package com.sy.hr.dg.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReadForSeqRequest {
    /**
     * @className UserReadForEmailRequest
     * @description 회원 정보 조회, 회원 탈퇴
     */

    private Long userSeq;

}
