package com.sy.hr.dg.answer.vo;

import com.sy.hr.dg.common.vo.CodeVO;
import com.sy.hr.dg.like.vo.LikeAnswer;
import com.sy.hr.dg.problem.vo.Problem;
import com.sy.hr.dg.user.vo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerSeq;

    @ManyToOne
    private Problem problem;

    @OneToOne
    private CodeVO codeVO; // languageCode

    @ManyToOne
    private User user;

    private String answer;

    @CreatedDate
    private LocalDate regDate;

    @LastModifiedDate
    private LocalDate updtDate;
    private String successYn;
    private String openYn;
    private Long time;
    private Long memory;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "answer")
    private List<LikeAnswer> likeAnswerList;
}
