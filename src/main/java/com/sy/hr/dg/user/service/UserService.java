package com.sy.hr.dg.user.service;

import com.sy.hr.dg.email.repository.EmailRepository;
import com.sy.hr.dg.email.service.EmailService;
import com.sy.hr.dg.email.vo.Email;
import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.user.repository.UserRepository;
import com.sy.hr.dg.user.request.*;
import com.sy.hr.dg.user.response.*;
import com.sy.hr.dg.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

import static com.sy.hr.dg.model.network.Header.OK;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private EmailService emailService;

    @Value("${aws.ses.veritied.email}")
    private String fromEmail;

    public Header<UserDoubleCheckResponse> doubleCheckEmail(String email) {

        Optional<User> user = userRepository.findByEmail( email );

        return user.map( u -> {
            UserDoubleCheckResponse response = UserDoubleCheckResponse.builder().duplicateYn("Y").build();
            return Header.OK( response );
        }).orElseGet( () -> {
            UserDoubleCheckResponse response = UserDoubleCheckResponse.builder().duplicateYn("N").build();
            return Header.OK( response );
        });
    }

    public Header registUser(Header<UserRegistRequest> request) {
        log.info( "request => {}", request );

        UserRegistRequest userRegistRequest = request.getData();
        User newUser = userRepository.save( userRegistRequest.getUser() );

        return OK();
    }

    public Header<UserReadForEmailResponse> readUser( Long userSeq ) {
        log.info("readUser userSeq => {}", userSeq);

        Optional<User> user = userRepository.findById( userSeq );

        return user.map( u -> {
            UserReadForEmailResponse response = UserReadForEmailResponse.builder()
                    .userName(u.getUserName())
                    .password(u.getPassword()) // todo 암호화, 길이
                    .email(u.getEmail())
                    .nickname(u.getNickname())
                    .mobile(u.getMobile())
                    .tryCount(u.getTryCount())
                    .successCount(u.getSuccessCount())
                    .deleteYn(u.getDeleteYn())
                    .build();
            return Header.OK( response );
        }).orElseGet( () -> Header.ERROR( "존재하지 않는 회원입니다." ) );
    }

    public Header modifyUser(Header<UserModifyRequest> request) {
        log.info("modifyUser request => {}", request);

        UserModifyRequest userModifyRequest = request.getData();
        userRepository.save( userModifyRequest.getUser() );

        return Header.OK( "회원 정보가 수정되었습니다." );
    }

    public Header<UserDoubleCheckResponse> doubleCheckNickname(String nickname) {
        log.info("doubleCheckNickname nickname => {}", nickname);

        Optional<User> user = userRepository.findByNickname( nickname );

        log.info("doubleCheckNickname user => {}", user);

        return user.map( u -> {
            UserDoubleCheckResponse response = UserDoubleCheckResponse.builder().duplicateYn("Y").build();
            return Header.OK( response );
        }).orElseGet( () -> {
            UserDoubleCheckResponse response = UserDoubleCheckResponse.builder().duplicateYn("N").build();
            return Header.OK( response );
        });
    }

    public Header<UserFindEmailResponse> searchEmail(Header<UserFindEmailRequest> request) {
        log.info("serachEmail request => {}", request);

        UserFindEmailRequest userFindEmailRequest = request.getData();
        Optional<User> getUser = userRepository.findByUserNameAndMobile( userFindEmailRequest.getUserName(), userFindEmailRequest.getMobile() );

        return getUser.map( u -> {
            UserFindEmailResponse response = UserFindEmailResponse.builder().email( u.getEmail() ).build();
            return Header.OK( response );
        }).orElseGet( () -> Header.ERROR("존재하지 않는 회원입니다.") );
    }

    public Header<UserSendEmailResponse> sendEmail(Header<UserSendEmailRequest> request) {
        // 1. 데이터
        UserSendEmailRequest userSendEmailRequest = request.getData();

        log.info( "userSendEmailRequest -> {}", userSendEmailRequest );

        // 2. 회원 여부 확인
        return userRepository.findByEmailAndUserName( userSendEmailRequest.getEmail(), userSendEmailRequest.getUserName() )
                .map( u -> {
                    // 3. 인증번호 생성 (6자리)
                    int num = (int)(Math.random() * (999999 - 100000 + 1)) + 100000;

                    String title = "[DG] 비밀 번호 변경 인증 번호";
                    String content = "인증 번호는 [" + num + "] 입니다.";

                    // 4. 메일 발송
                    Map<String, String> sendEmailResult = emailService.sendEmail( userSendEmailRequest.getEmail(), fromEmail, title, content );

                    Optional<Map<String, String>> sendEmailResultOptional = Optional.of( sendEmailResult );

                    return sendEmailResultOptional.filter(
                            s -> s.get( "status" ).equals( "success" )
                    ).map( s -> {
                        Optional<User> user = userRepository.findByEmail( userSendEmailRequest.getEmail() );
                        Email email = userSendEmailRequest.sendEmailInfo( "Y", fromEmail, title, content, user.get() );
                        emailRepository.save( email );

                        UserSendEmailResponse userSendEmailResponse = UserSendEmailResponse.builder()
                                .sendYn( "Y" )
                                .userSeq( user.get().getUserSeq() )
                                .build();

                        return Header.OK( userSendEmailResponse );
                    }).orElseGet( () -> Header.ERROR( "인증 메일 발송을 실패했습니다." ) );
                })
                .orElseGet(() -> Header.ERROR("존재하지 않는 회원입니다."));
    }

    public Header<UserAuthResponse> authEmail(Header<UserAuthRequest> request) {
        UserAuthRequest userAuthRequest = request.getData();
        Optional<User> user = userRepository.findById( userAuthRequest.getUserSeq() );
        Optional<Email> authEmail = emailRepository.findByUserAndContentsContaining( user, userAuthRequest.getAuthCode() );

        return authEmail.map( auth -> {
            Email updateEmail = Email.builder()
                    .emailSeq( authEmail.get().getEmailSeq() )
                    .user( user.get() )
                    .authYn( "Y" )
                    .sendYn( userAuthRequest.getSendYn() )
                    .build();

            emailRepository.save( updateEmail );

            UserAuthResponse userAuthResponse = UserAuthResponse.builder()
                    .authYn( "Y" )
                    .userSeq( user.get().getUserSeq() )
                    .build();

            return Header.OK( userAuthResponse );
        }).orElseGet(() -> Header.ERROR("일치하지 않는 인증 번호입니다.") );
    }

    public Header changePassword(Header<UserModifyPasswordRequest> request) {
        UserModifyPasswordRequest userModifyPasswordRequest = request.getData();

        User user = userModifyPasswordRequest.getUser();

        Optional<User> changePassword = userRepository.findById( user.getUserSeq() );

        return changePassword.map( c -> {
            c.setPassword( user.getPassword() );
            userRepository.save( c );
            return Header.OK( "비밀번호가 변경되었습니다." );
        }).orElseGet( () -> Header.ERROR( "에러가 발생했습니다." ) );
    }

    @Transactional
    public Header withdrawalUser(Long userSeq) {
        Optional<User> user = userRepository.findById( userSeq );

        return user.map( u -> {
            u.setDeleteYn( "Y" );
            userRepository.save( u );
            return Header.OK( "탈퇴 되었습니다." );
        }).orElseGet( () -> Header.ERROR( "에러가 발생했습니다." ) );
    }

    public Header login(Header<UserLoginRequest> request) {
        UserLoginRequest userLoginRequest = request.getData();

        Optional<User> user = userRepository.findByEmailAndPassword( userLoginRequest.getEmail(), userLoginRequest.getPassword() );

        // 세션 처리 필요 (스프링 시큐리티?)

        return user.map( u -> Header.OK( "로그인 되었습니다." ) ).orElseGet( () -> Header.ERROR("이메일 혹은 패스워드를 확인해주세요.") );
    }
}


