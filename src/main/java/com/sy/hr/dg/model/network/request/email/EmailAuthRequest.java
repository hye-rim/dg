package com.sy.hr.dg.model.network.request.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailAuthRequest {

    private Long userSeq;

    private String email;

    private Long auth_code;

}
