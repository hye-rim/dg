package com.sy.hr.dg.user.controller;

import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.user.request.*;
import com.sy.hr.dg.user.response.*;
import com.sy.hr.dg.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/doubleCheckEmail/{email}")
    public Header<UserDoubleCheckResponse> doubleCheckEmail( @PathVariable String email ) {
        /**
         * @description 이메일 중복 확인
         * @method doubleCheckEmail
         * @params [email]
         * @return java.lang.Long
         *
         * @author sy
         * @since 2020-12-14
         */
        System.out.println( userService.doubleCheckEmail( email ) );

        return userService.doubleCheckEmail( email );
    }

    @PostMapping
    public Header registUser( @RequestBody Header<UserRegistRequest> request ) {
        /**
         * @description 회원 정보 등록
         * @method registUser
         * @params [request]
         * @return com.sy.hr.dg.model.network.Header
         *
         * @author hr
         * @since 2020-11-25
         */
        log.info( "request => {}", request );

        return userService.registUser( request );
    }

    @GetMapping("/{email}")
    public Header<UserReadForEmailResponse> readUser( @PathVariable String email ) {
        /**
         * @description 회원 정보 조회
         * @method readUser
         * @params [email]
         * @return com.sy.hr.dg.model.network.Header<com.sy.hr.dg.model.network.response.user.UserReadForEmailResponse>
         *
         * @author hr
         * @since 2020-11-25
         */
        log.info( "email => {}", email );

        return userService.readUser( email );
    }

    @PutMapping
    public Header modifyUser( @RequestBody Header<UserUpdateRequest> request ) {
        /**
         * @description 회원 정보 수정
         * @method modifyUser
         * @params [request]
         * @return com.sy.hr.dg.model.network.Header
         *
         * @author hr
         * @since 2020-11-25
         */
        return userService.modifyUser( request );
    }

    @GetMapping("/nickname/{nickname}")
    public Header<UserDoubleCheckResponse> doubleCheckNickname(@PathVariable String nickname ) {
        /**
         * @description 닉네임 중복 확인
         * @method doubleCheckNickname
         * @params [nickname]
         * @return com.sy.hr.dg.model.network.Header
         *
         * @author sy
         * @since 2020-11-29
         */
        return userService.doubleCheckNickname( nickname );
    }

    @PostMapping("/search-email")
    public Header<UserFindEmailResponse> searchEmail(@RequestBody Header<UserFindEmailRequest> request ) {
        /**
         * @description 이메일 찾기
         * @method searchEmail
         * @params [request]
         * @return com.sy.hr.dg.model.network.Header
         *
         * @author sy
         * @since 2020-12-06
        */
        return userService.searchEmail( request );
    }

    @PostMapping("/send")
    public Header<UserSendEmailResponse> sendEmail( @RequestBody Header<UserSendEmailRequest> request ) {
        /**
         * @description 이메일 전송
         * @method sendEmail
         * @params [request]
         * @return com.sy.hr.dg.model.network.Header<com.sy.hr.dg.user.response.UserSendEmailResponse>
         *
         * @author sy
         * @since 2020-12-12
        */
        return userService.sendEmail( request );
    }

    @PostMapping("/auth")
    public Header<UserAuthResponse> authEmail( @RequestBody Header<UserAuthRequest> request ) {
        /**
         * @description 이메일 인증 - 전송된 이메일에 있는 인증 코드로 인증
         * @method authEmail
         * @params [request]
         * @return com.sy.hr.dg.model.network.Header<com.sy.hr.dg.user.response.UserAuthResponse>
         *
         * @author sy
         * @since 2020-12-08
        */
        return userService.authEmail( request );
    }

    @PutMapping("/password")
    public Header changePassword( @RequestBody Header<UserModifyPasswordRequest> request ) {
        /**
         * @description 비밀번호 변경 - 이메일 인증 후 비밀번호 변경
         * @method changePassword
         * @params [request]
         * @return com.sy.hr.dg.model.network.Header
         *
         * @author sy
         * @since 2020-12-15
        */
        return userService.changePassword( request );
    }

    @PutMapping("/{userSeq}")
    public Header withdrawalUser( @PathVariable Long userSeq ) {
        /**
         * @description 회원 탈퇴
         * @method withdrawalUser
         * @params [userSeq]
         * @return com.sy.hr.dg.model.network.Header
         *
         * @author sy
         * @since 2020-12-15
        */
        return userService.withdrawalUser( userSeq );
    }

    @PostMapping("/login")
    public Header login( @RequestBody Header<UserLoginRequest> request ) {
        /**
         * @description 로그인
         * @method login
         * @params [request]
         * @return com.sy.hr.dg.model.network.Header
         *
         * @author sy
         * @since 2020-12-24
        */
        return userService.login( request );
    }
}
