package com.sy.hr.dg.answer.vo;

import com.sy.hr.dg.like.vo.LikeAnswer;
import com.sy.hr.dg.problem.vo.Problem;
import com.sy.hr.dg.user.vo.User;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)  //CreateDate, LastModifiedDate 사용 시 추가해야함
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

//    private Long problemSeq;
//    private Long userSeq;

   // @OneToOne
    private String languageCode; // languageCode

    private String answer;

    @CreatedDate
   // @Column(insertable = false, updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
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

}
