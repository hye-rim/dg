package com.sy.hr.dg.like.vo;

import com.sy.hr.dg.answer.vo.AnswerVO;
import com.sy.hr.dg.user.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TB_LIKE")
public class LikeVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeSeq;

    @ManyToOne
    private AnswerVO answerVO;

    @ManyToOne
    private UserVO userVO;

    private LocalDate regDate;
    private LocalDate updtDate;
}
