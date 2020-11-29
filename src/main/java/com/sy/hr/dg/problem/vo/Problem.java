package com.sy.hr.dg.problem.vo;

import com.sy.hr.dg.answer.vo.Answer;
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
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long problemSeq;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @Column(updatable = false)
    private String level;

    @Column(updatable = false)
    private String problemTitle;

    @Column(updatable = false)
    private String problemContents;

    @CreatedDate
    private LocalDate regDate;

    @LastModifiedDate
    private LocalDate updtDate;

    @Column(updatable = false)
    private String input;

    @Column(updatable = false)
    private String output;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    private List<Answer> answerList;
}
