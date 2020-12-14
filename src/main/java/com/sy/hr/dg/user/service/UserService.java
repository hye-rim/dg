package com.sy.hr.dg.user.service;

import com.sy.hr.dg.email.repository.EmailRepository;
import com.sy.hr.dg.email.vo.Email;
import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.problem.vo.Problem;
import com.sy.hr.dg.user.repository.UserRepository;
import com.sy.hr.dg.user.request.*;
import com.sy.hr.dg.user.response.*;
import com.sy.hr.dg.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.sy.hr.dg.model.network.Header.OK;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

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

        User user = User.builder()
                .userName( userRegistRequest.getUserName() )
                .email( userRegistRequest.getEmail() )
                .nickname( userRegistRequest.getNickname() )
                .password( userRegistRequest.getPassword() )
                .mobile( userRegistRequest.getMobile() )
                .build();

        User newUser = userRepository.save( user );

        return OK();
    }

    public Header<UserReadForEmailResponse> readUser(String email) {
        log.info("readUser email => {}", email);

        Optional<User> user = userRepository.findByEmail( email );

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

        UserModifyRequest uerModifyRequest = request.getData();

        User user = User.builder()
                .userSeq( uerModifyRequest.getUserSeq() )
                .password( uerModifyRequest.getPassword() )
                .mobile( uerModifyRequest.getMobile() )
                .build();

        userRepository.save(user);

        return Header.OK();
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

        User user = User.builder()
                    .userName( userFindEmailRequest.getUserName() )
                    .mobile( userFindEmailRequest.getMobile() )
                    .build();

        Optional<User> getUser = userRepository.findByUserNameAndMobile( user.getUserName(), user.getMobile() );

        return getUser.map( u -> {
                    UserFindEmailResponse response = UserFindEmailResponse.builder().email( u.getEmail() ).build();
                    return Header.OK( response );
                })
               .orElseGet( () -> Header.ERROR("존재하지 않는 회원입니다.") );
    }

    public Header<UserSendEmailResponse> sendEmail(Header<UserSendEmailRequest> request) {
        // 1. 데이터
        UserSendEmailRequest userSendEmailRequest = request.getData();

        log.info( "userSEndEmailRequest -> {}", userSendEmailRequest );

        // 2. 인증번호 생성 (6자리)
        int num = (int)(Math.random() * (999999 - 100000 + 1)) + 100000;

        String title = "[DG] 비밀 번호 변경 인증 번호";
        String content = "인증 번호는 [" + num + "] 입니다.";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo( userSendEmailRequest.getEmail() );
        simpleMailMessage.setSubject( title );
        simpleMailMessage.setText( content );

        javaMailSender.send( simpleMailMessage );

        Optional<User> user = userRepository.findByEmail( userSendEmailRequest.getEmail() );

        Email sendEmail = Email.builder()
                          .sendYn( "Y" )
                          .title( title )
                          .contents( content )
                          .receiver( userSendEmailRequest.getEmail() )
                          .user( user.get() )
                          .build();

        emailRepository.save( sendEmail );

        UserSendEmailResponse userSendEmailResponse = UserSendEmailResponse.builder()
                                                      .sendYn( "Y" )
                                                      .userSeq( user.get().getUserSeq() )
                                                      .build();

        return Header.OK( userSendEmailResponse );
    }

    public Header<UserAuthResponse> authEmail(Header<UserAuthRequest> request) {
        UserAuthRequest userAuthRequest = request.getData();
        UserAuthResponse userAuthResponse = new UserAuthResponse();
        Optional<User> user = userRepository.findById( userAuthRequest.getUserSeq() );
        Optional<Email> authEmail = emailRepository.findByContentsContaining( userAuthRequest.getAuthCode() );

        return authEmail.map( auth -> {
            Email updateEmail = Email.builder()
                    .emailSeq( authEmail.get().getEmailSeq() )
                    .user( user.get() )
                    .authYn( "Y" )
                    .build();

            emailRepository.save( updateEmail );

            userAuthResponse.setAuthYn("Y");
            userAuthResponse.setUserSeq( user.get().getUserSeq() );

            return Header.OK( userAuthResponse );
        })
        .orElseGet(() -> Header.ERROR("일치하지 않는 인증번호 입니다.") );
    }
}


