package com.sy.hr.dg.user.repository;

import com.sy.hr.dg.DgApplicationTests;
import com.sy.hr.dg.user.vo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends DgApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setUserName("주");
        user.setEmail("j@abc.com");
        user.setNickname("Joo");
        user.setPassword("dream1004!");
        user.setMobile("01000001111");
        user.setRegDate(LocalDateTime.now());
        user.setUpdtDate(LocalDateTime.now());
        user.setSuccessCount(0);
        user.setTryCount(0);

        User newUser = userRepository.save(user);

        System.out.println( newUser );
    }

    @Test
    public void count() {
        System.out.println( userRepository.countByEmail( "j@abc.com" ) );
    }

}
