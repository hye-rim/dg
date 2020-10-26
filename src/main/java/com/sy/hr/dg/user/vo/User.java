package com.sy.hr.dg.user.vo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.like.vo.LikeAnswer;
import com.sy.hr.dg.problem.vo.Problem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;
    private String userName;
    private String email;
    private String nickname;
    private String password;
    private Integer mobile;
    private Integer tryCount;
    private Integer successCount;
    private LocalDateTime regDate;
    private LocalDateTime updtDate;

    //@Column(name = "DELETE_YN")
    private String deleteYn;

    @OneToMany(mappedBy = "user")
    private List<Problem> problemList;

    @OneToMany(mappedBy = "user")
    private List<Answer> answerList;

    @OneToMany(mappedBy = "user")
    private List<LikeAnswer> likeAnswerList;
}
