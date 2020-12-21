package com.sy.hr.dg.problem.vo;

import com.sy.hr.dg.user.vo.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long problemSeq;

    /*@ManyToOne(optional = false)
    @JoinColumn(name = "user_seq", foreignKey = @ForeignKey( name = "FK_TB_USER_TO_TB_PROBLEM" ))*/
    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @Column(updatable = false)
    private String level;

    @Column(updatable = false)
    private String problemTitle;

    @Column(updatable = false)
    private String problemContents;

    @CreationTimestamp
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime updtDate;

    @Column(updatable = false)
    private String input;

    @Column(updatable = false)
    private String output;

    @Column(updatable = false)
    private String status;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "problem")
    private List<Answer> answerList;*/
}
