package com.sy.hr.dg.answer.vo;

import com.sy.hr.dg.like.vo.LikeAnswer;
import com.sy.hr.dg.problem.vo.Problem;
import com.sy.hr.dg.user.vo.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerSeq;

    @ManyToOne
    @JoinColumn(name = "problem_seq")
    private Problem problem;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    private String languageCode;

    private String answer;

    @CreationTimestamp
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime updtDate;

    @Column(insertable = false)
    private String successYn;

    @Column(insertable = false)
    private String openYn;

    private Long time;

    private Long memory;

    @OneToMany(mappedBy = "answer")
    private List<LikeAnswer> likeAnswer;

}
