package com.sy.hr.dg.problem.vo;

import com.sy.hr.dg.answer.vo.AnswerVO;
import com.sy.hr.dg.common.vo.CodeVO;
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
@Table(name="TB_PROBLEM_LIST")
@AllArgsConstructor
@NoArgsConstructor
public class ProblemVO {

    @Id
    @GeneratedValue
    private String problemCode;

    @OneToMany
    private List<CodeVO> languageList = new ArrayList<>();

    @ManyToOne
    private UserVO userVO;

    private String level;
    private String problemTitle;
    private String problemContents;
    private LocalDate regDate;
    private LocalDate updtDate;
    private String input;
    private String output;

    @OneToMany(mappedBy = "problemVO")
    private List<AnswerVO> answerVOList;
}
