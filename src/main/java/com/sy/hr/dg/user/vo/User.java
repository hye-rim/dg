package com.sy.hr.dg.user.vo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.like.vo.LikeAnswer;
import com.sy.hr.dg.problem.vo.Problem;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(insertable = false, updatable = false)
    private LocalDateTime regDate;

    @Column(insertable = false, updatable = false)
    private LocalDateTime updtDate;

    //@Column(name = "DELETE_YN")
    private String deleteYn;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<Problem> problemList;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "user")
    private List<Answer> answerList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<LikeAnswer> likeAnswerList;
}
