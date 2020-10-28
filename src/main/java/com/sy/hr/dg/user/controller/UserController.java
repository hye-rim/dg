package com.sy.hr.dg.user.controller;

import com.sy.hr.dg.user.service.UserService;
import com.sy.hr.dg.user.vo.User;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/doubleCheckEmail")
    public Long  doubleCheckEmail(@Param( value="email" ) String email ) {

        System.out.println( "email >>> " + email );

        System.out.println( userService.doubleCheckEmail( email ) );

       return userService.doubleCheckEmail( email );
    }

}
