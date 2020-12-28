package com.sy.hr.dg.email.repository;

import com.sy.hr.dg.email.vo.Email;
import com.sy.hr.dg.user.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    Optional<Email> findByUserAndContentsContaining(Optional<User> user, String authCode);
}
