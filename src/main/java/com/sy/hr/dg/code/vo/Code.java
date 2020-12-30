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

/**
 * @className Code
 * @description 추후 문제 목록 조회 시 코드 검색이나 답안 작성 시 언어 선택 할때 코드 조회 시 활용
 *              관리자에서 코드 추가 삭제 기능도 필요함
 */
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
