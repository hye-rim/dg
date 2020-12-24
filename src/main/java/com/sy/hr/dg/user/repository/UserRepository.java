package com.sy.hr.dg.user.repository;

import com.sy.hr.dg.user.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Long countByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByNickname(String nickname);

    Optional<User> findByUserNameAndMobile(String userName, String mobile);

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmailAndUserName(String email, String userName);
}
