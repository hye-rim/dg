package com.sy.hr.dg.user.vo;

import com.sy.hr.dg.answer.vo.AnswerVO;
import com.sy.hr.dg.like.vo.LikeVO;
import com.sy.hr.dg.problem.vo.ProblemVO;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@Table (name = "TB_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    @Id
    @GeneratedValue
    private String userCode;
    private String userName;
    private String email;
    private String nickname;
    private String password;
    private Integer mobile;
    private Integer tryCount;
    private Integer successCount;
    private LocalDateTime regDate;
    private LocalDateTime updtDate;
    private String deleteYn;

    @OneToMany(mappedBy = "userVO")
    private List<ProblemVO> problemVOList;

    @OneToMany(mappedBy = "userVO")
    private List<AnswerVO> answerVOList;

    @OneToMany(mappedBy = "userVO")
    private List<LikeVO> likeVOList;
}
