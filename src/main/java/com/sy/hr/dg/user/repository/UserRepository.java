package com.sy.hr.dg.user.repository;

import com.sy.hr.dg.user.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Long  countByEmail(String email);
}
