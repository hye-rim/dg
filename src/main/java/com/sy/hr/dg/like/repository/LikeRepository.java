package com.sy.hr.dg.like.repository;

import com.sy.hr.dg.like.vo.LikeAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikeAnswer, Long> {

}
