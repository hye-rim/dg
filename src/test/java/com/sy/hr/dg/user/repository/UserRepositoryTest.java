package com.sy.hr.dg.user.repository;

import com.sy.hr.dg.DgApplicationTests;
import com.sy.hr.dg.user.vo.UserVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends DgApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        UserVO userVO = new UserVO();
        userVO.setUserName("jhr");
        userVO.setEmail("j@abc.com");
        userVO.setNickname("Joo");
        userVO.setPassword("dream1004!");
        userVO.setMobile(01000001111);
        userVO.setRegDate(LocalDateTime.now());
        userVO.setUpdtDate(LocalDateTime.now());
        userVO.setSuccessCount(0);
        userVO.setTryCount(0);

        UserVO newUser = userRepository.save( userVO );

        System.out.println( newUser );
    }

}
