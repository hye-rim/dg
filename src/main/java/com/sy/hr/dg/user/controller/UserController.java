package com.sy.hr.dg.user.controller;

import com.sy.hr.dg.common.ifs.CrudInterface;
import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.model.network.request.user.UserRegistRequest;
import com.sy.hr.dg.user.service.UserService;
import com.sy.hr.dg.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController implements CrudInterface {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/doubleCheckEmail")
    public Long doubleCheckEmail(@Param( value="email" ) String email ) {
        System.out.println( userService.doubleCheckEmail( email ) );

        return userService.doubleCheckEmail( email );
    }

  /*  @PostMapping
    public Header regist( @RequestBody Header<UserRegistRequest> request ) {
        log.info( "request => {}", request );

        return userService.registUser( request );
    }
*/
    @Override
    public Header regist( @RequestBody Header<UserRegistRequest> request ) {
        log.info( "request => {}", request );

        return userService.registUser( request );
    }

    @Override
    public Header read(Long id) {
        return null;
    }

    @Override
    public Header update(Header request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }
}
