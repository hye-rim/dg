package com.sy.hr.dg.answer.vo;

import com.sy.hr.dg.like.vo.LikeAnswer;
import com.sy.hr.dg.problem.vo.Problem;
import com.sy.hr.dg.user.vo.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(exclude = {"problem","user"})
//@Accessors(chain = true)
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

    private String languageCode; // languageCode

    private String answer;

    @CreationTimestamp
   // @Column(insertable = false, updatable = false)
    private LocalDateTime regDate;

    @UpdateTimestamp
    //@Column(insertable = false, updatable = false)
    private LocalDateTime updtDate;

    @Column(insertable = false, updatable = false)
    private String successYn;

    @Column(insertable = false, updatable = false)
    private String openYn;

    @Column(updatable = false)
    private Long time;

    @Column(updatable = false)
    private Long memory;

    @OneToMany(mappedBy = "answer")
    private Collection<LikeAnswer> likeAnswer;

}
