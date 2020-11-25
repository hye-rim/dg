package com.sy.hr.dg.answer.vo;

import com.sy.hr.dg.common.vo.CodeVO;
import com.sy.hr.dg.like.vo.LikeAnswer;
import com.sy.hr.dg.problem.vo.Problem;
import com.sy.hr.dg.user.vo.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)  //CreateDate, LastModifiedDate 사용 시 추가해야함
@Getter
@Setter
@Builder
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

    @Column(insertable = false, updatable = false)
    private String successYn;

    @Column(insertable = false, updatable = false)
    private String openYn;

    private Long time;

    private Long memory;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "answer")
    private List<LikeAnswer> likeAnswerList;
}