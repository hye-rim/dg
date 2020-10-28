package com.sy.hr.dg.user.service;

import com.sy.hr.dg.user.repository.UserRepository;
import com.sy.hr.dg.user.vo.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long  doubleCheckEmail(String email) {
        System.out.println("UserService 진입");
        return userRepository.countByEmail( email );
    }
}
