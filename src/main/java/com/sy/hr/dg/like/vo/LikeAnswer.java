package com.sy.hr.dg.like.vo;

import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.user.vo.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)  //CreateDate, LastModifiedDate 사용 시 추가해야함
@Getter
@Setter
@Builder
@ToString(exclude = {"answer","user"})
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

    @CreatedDate
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime updtDate;

}
