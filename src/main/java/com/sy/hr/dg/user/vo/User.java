package com.sy.hr.dg.user.vo;

import lombok.*;
import org.hibernate.annotations.*;
//import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DynamicUpdate  // save() 메서드 사용 시 해당 테이블 컬럼의 default 값이 적용 되지 않아 문제가 발생 함 이때 @DynamicUpdate 를 추가하면 정상적으로 작동
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@DynamicInsert
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq")
    private Long userSeq;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String nickname;

    @Column
    private String password;

    @Column
    private String mobile;

    @Column(columnDefinition = "0")
    private Integer tryCount;

    @Column(columnDefinition = "0")
    private Integer successCount;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime regDate;

    @Column
    @UpdateTimestamp
    private LocalDateTime updtDate;

    @Column(columnDefinition = "N")
    private String deleteYn;

}
