package com.sy.hr.dg.answer.vo;

import com.sy.hr.dg.common.vo.CodeVO;
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
@Table(name="TB_ANSWER")
@AllArgsConstructor
@NoArgsConstructor
public class AnswerVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String answerCode;

    @ManyToOne
    private ProblemVO problemVO;

    @OneToOne
    private CodeVO codeVO; // languageCode

    @ManyToOne
    @JoinColumn(name = "USER_CODE")
    private UserVO userCode;

    private String answer;
    private LocalDate regDate;
    private LocalDate updtDate;
    private String successYn;
    private String openYn;
    private Long time;
    private Long memory;
}
