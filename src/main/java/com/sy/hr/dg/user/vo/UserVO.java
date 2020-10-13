package com.sy.hr.dg.user.vo;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@Table (name = "TB_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    @Id
    @GeneratedValue
    private String userCode;
    private String userName;
    private String email;
    private String nickname;
    private String password;
    private Integer mobile;
    private Integer tryCount;
    private Integer successCount;
    private LocalDateTime regDate;
    private LocalDateTime updtDate;
    private String deleteYn;


    public UserVO() {
    }
}
