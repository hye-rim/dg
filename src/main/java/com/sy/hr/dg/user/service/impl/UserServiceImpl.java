package com.sy.hr.dg.user.service.impl;

import com.sy.hr.dg.user.repository.UserRepository;
import com.sy.hr.dg.user.vo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public Long  doubleCheckEmail(String email) {
        System.out.println("UserServiceImpl 진입");
        return userRepository.countByEmail( email );
    }
}
