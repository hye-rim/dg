package com.sy.hr.dg.like.vo;

import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.user.vo.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)  //CreateDate, LastModifiedDate 사용 시 추가해야함
@Getter
@Setter
@Builder
public class LikeAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeSeq;

    @ManyToOne
    private Answer answer;

    @ManyToOne
    private User user;

    @CreatedDate
    private LocalDate regDate;

    @LastModifiedDate
    private LocalDate updtDate;
}
