package com.sy.hr.dg.like.vo;

import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.user.vo.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LikeAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeSeq;

    @ManyToOne
    @JoinColumn(name = "answer_seq")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime updtDate;

}
