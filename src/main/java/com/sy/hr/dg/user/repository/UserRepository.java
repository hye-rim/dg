package com.sy.hr.dg.user.repository;

import com.sy.hr.dg.user.response.UserReadForEmailResponse;
import com.sy.hr.dg.user.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Long countByEmail(String email);

    UserReadForEmailResponse findByEmail(String email);
}
