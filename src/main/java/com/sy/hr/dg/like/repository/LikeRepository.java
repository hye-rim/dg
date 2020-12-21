package com.sy.hr.dg.like.repository;

import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.like.vo.LikeAnswer;
import com.sy.hr.dg.user.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<LikeAnswer, Long> {

    Optional<LikeAnswer> findByLikeSeq(Long likeSeq);

    Long countByUserAndAnswer(User user, Answer answer);

    Long countByAnswer(Answer answer);

    //Answer findByAnswerSeq(Long answerSeq);
}
