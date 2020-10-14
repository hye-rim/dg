package com.sy.hr.dg.answer.vo;

import com.sy.hr.dg.common.vo.CodeVO;
import com.sy.hr.dg.like.vo.LikeVO;
import com.sy.hr.dg.problem.vo.ProblemVO;
import com.sy.hr.dg.user.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="tb_answer")
@AllArgsConstructor
@NoArgsConstructor
public class AnswerVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerSeq;

    @ManyToOne
    private ProblemVO problemVO;

    @OneToOne
    private CodeVO codeVO; // languageCode

    @ManyToOne
    private UserVO userVO;

    private String answer;
    private LocalDate regDate;
    private LocalDate updtDate;
    private String successYn;
    private String openYn;
    private Long time;
    private Long memory;

    @OneToMany(mappedBy = "answerVO")
    private List<LikeVO> likeVOList;
}
