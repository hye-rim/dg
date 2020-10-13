package com.sy.hr.dg.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name="TB_COMMON_CODE")
@AllArgsConstructor
@NoArgsConstructor
public class CodeVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;

    private String codeGroup;
    private String codeDiscription;
    private LocalDate regDate;
    private LocalDate updtDate;
    private String codeName;

}
