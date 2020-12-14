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

    @Column(updatable = false)
    private String contents;

    @Column(insertable = false, updatable = false)
    private String sendYn;

    @Column(insertable = false)
    private String authYn;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updtDate;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @Column(updatable = false)
    private String sender;

    @Column(updatable = false)
    private String receiver;

    @Column(updatable = false)
    private String title;

}
