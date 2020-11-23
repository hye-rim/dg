package com.sy.hr.dg.user.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.sy.hr.dg.answer.vo.Answer;
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
    private String userName;
    private String email;
    private String nickname;
    private String password;
    private String mobile;

    @Column(insertable = false, updatable = false)
    private Integer tryCount;

    @Column(insertable = false, updatable = false)
    private Integer successCount;

    @CreatedDate
    private LocalDate regDate;

    @LastModifiedDate
    private LocalDate updtDate;

    //@Column(name = "DELETE_YN")
    private String deleteYn;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<Problem> problemList;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "user")
    private List<Answer> answerList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<LikeAnswer> likeAnswerList;
}
