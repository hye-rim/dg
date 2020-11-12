package com.sy.hr.dg.problem.vo;

import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.common.vo.CodeVO;
import com.sy.hr.dg.user.vo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long problemSeq;

    @OneToMany
    private List<CodeVO> languageList = new ArrayList<>();

    @ManyToOne
    private User user;

    private String level;
    private String problemTitle;
    private String problemContents;

    @CreatedDate
    private LocalDate regDate;

    @LastModifiedDate
    private LocalDate updtDate;
    private String input;
    private String output;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    private List<Answer> answerList;
}
