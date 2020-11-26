package com.sy.hr.dg.user.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.email.vo.Email;
import com.sy.hr.dg.like.vo.LikeAnswer;
import com.sy.hr.dg.problem.vo.Problem;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)  //CreateDate, LastModifiedDate 사용 시 추가해야함
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(updatable = false)
    private String userName;

    @Column(updatable = false)
    private String email;

    @Column(updatable = false)
    private String nickname;

    @Column(updatable = false)
    private String password;

    @Column(updatable = false)
    private String mobile;

    //DB에 default value가 정해져 있으면 insertable=false 아니면 true , tryCount default = 0
    @Column(insertable = false, updatable = false)
    private Integer tryCount;

    //DB에 default value가 정해져 있으면 insertable=false 아니면 true , successCount default = 0
    @Column(insertable = false, updatable = false)
    private Integer successCount;

    @CreatedDate
    @Column(updatable = false)
    private LocalDate regDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDate updtDate;

    //DB에 default value가 정해져 있으면 insertable=false 아니면 true , deleteYn default = N
    @Column(insertable = false, updatable = false)
    private String deleteYn;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<Problem> problemList;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "user")
    private List<Answer> answerList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<LikeAnswer> likeAnswerList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Email> emailList;
}
