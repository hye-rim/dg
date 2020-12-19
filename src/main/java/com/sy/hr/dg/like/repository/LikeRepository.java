package com.sy.hr.dg.like.repository;

import com.sy.hr.dg.answer.vo.Answer;
import com.sy.hr.dg.like.vo.LikeAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<LikeAnswer, Long> {

    Optional<LikeAnswer> findByLikeSeq(Long likeSeq);

    Answer findByAnswerSeq(Long answerSeq);
}
