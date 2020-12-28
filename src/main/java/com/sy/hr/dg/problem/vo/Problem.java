package com.sy.hr.dg.problem.vo;

import com.sy.hr.dg.user.vo.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@DynamicUpdate
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long problemSeq;

    /*@ManyToOne(optional = false)
    @JoinColumn(name = "user_seq", foreignKey = @ForeignKey( name = "FK_TB_USER_TO_TB_PROBLEM" ))*/
    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    private String level;

    private String problemTitle;

    private String problemContents;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime updtDate;

    private String input;


    private String output;

    @Column(updatable = false)
    private String status;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    private List<Answer> answerList;*/

}
