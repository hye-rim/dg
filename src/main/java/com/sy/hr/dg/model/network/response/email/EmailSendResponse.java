package com.sy.hr.dg.model.network.response.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailSendResponse {

    private String sendYn;

    private Long userSEq;

}
