package com.sy.hr.dg.email.vo;

import com.sy.hr.dg.user.vo.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)  //CreateDate, LastModifiedDate 사용 시 추가해야함
@Getter
@Setter
@Builder
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailSeq;

    private String contents;

    @Column(insertable = false , updatable = false)
    private String sendYn;

    @Column(insertable = false , updatable = false)
    private String authYn;

    @CreatedDate
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime updtDate;

    @ManyToOne
    private User user;

}
