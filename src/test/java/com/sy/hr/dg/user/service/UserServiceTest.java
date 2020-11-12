package com.sy.hr.dg.user.service;


import com.sy.hr.dg.DgApplicationTests;
import com.sy.hr.dg.user.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class UserServiceTest extends DgApplicationTests {

    @Autowired
    private UserService userService;

//    @MockBean
//    private UserRepository userRepository;

    @Test
    public void serviceTest() {
        System.out.println( userService.doubleCheckEmail( "j@abc.com" ) );
    }

}
