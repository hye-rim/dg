package com.sy.hr.dg.code.vo;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)  //CreateDate, LastModifiedDate 사용 시 추가해야함
@Getter
@Setter
@Builder
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;

    private String codeGroup;
    private String codeDiscription;
    private LocalDateTime regDate;
    private LocalDateTime updtDate;
    private String codeName;

}
