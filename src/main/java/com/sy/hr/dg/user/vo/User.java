package com.sy.hr.dg.user.vo;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)  //CreateDate, LastModifiedDate 사용 시 추가해야 함
@Getter
@Setter
@Builder
@DynamicUpdate  // save() 메서드 사용 시 해당 테이블 컬럼의 default 값이 적용 되지 않아 문제가 발생 함 이때 @DynamicUpdate 를 추가하면 정상적으로 작동
//@SelectBeforeUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    private String userName;

    private String email;

    private String nickname;

    private String password;

    private String mobile;

    //DB에 default value가 정해져 있으면 insertable=false 아니면 true , tryCount default = 0
    private Integer tryCount;

    //DB에 default value가 정해져 있으면 insertable=false 아니면 true , successCount default = 0
    //@Column(insertable = false, updatable = false)
    private Integer successCount;

    @CreatedDate
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime updtDate;

    //DB에 default value가 정해져 있으면 insertable=false 아니면 true , deleteYn default = N
    private String deleteYn;

}
