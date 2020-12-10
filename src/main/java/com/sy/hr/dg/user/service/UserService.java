package com.sy.hr.dg.user.service;

import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.user.repository.UserRepository;
import com.sy.hr.dg.user.request.UserAuthRequest;
import com.sy.hr.dg.user.request.UserFindEmailRequest;
import com.sy.hr.dg.user.request.UserModifyRequest;
import com.sy.hr.dg.user.request.UserRegistRequest;
import com.sy.hr.dg.user.response.UserAuthResponse;
import com.sy.hr.dg.user.response.UserDoubleCheckResponse;
import com.sy.hr.dg.user.response.UserReadForEmailResponse;
import com.sy.hr.dg.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.sy.hr.dg.model.network.Header.OK;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long doubleCheckEmail(String email) {
        return userRepository.countByEmail( email );
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

        User user = userRepository.findByEmail( email );

        UserReadForEmailResponse userApiResponse = UserReadForEmailResponse.builder()
                .userName(user.getUserName())
                .password(user.getPassword()) // todo 암호화, 길이
                .email(user.getEmail())
                .nickname(user.getNickname())
                .mobile(user.getMobile())
                .tryCount(user.getTryCount())
                .successCount(user.getSuccessCount())
                .deleteYn(user.getDeleteYn())
                .build();

        return Header.OK(userApiResponse);
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

    public Header doubleCheckNickname(String nickname) {
        log.info("doubleCheckNickname nickname => {}", nickname);

        User user = userRepository.findByNickname( nickname );

        log.info("doubleCheckNickname user => {}", user);

        UserDoubleCheckResponse response = new UserDoubleCheckResponse();

        if( user == null )
            response.setDuplicateYn("Y");
        else
            response.setDuplicateYn("N");

        return Header.OK( response );
    }

    public Header searchEmail(Header<UserFindEmailRequest> request) {
        log.info("serachEmail request => {}", request);

        UserFindEmailRequest userFindEmailRequest = request.getData();

        User user = User.builder()
                    .userName( userFindEmailRequest.getUserName() )
                    .mobile( userFindEmailRequest.getMobile() )
                    .build();

        User getUser = userRepository.findByUserNameAndMobile( user.getUserName(), user.getMobile() );

        return OK( getUser );
    }

    /*
    public Header<UserAuthResponse> authEmail(Header<UserAuthRequest> request) {

        UserAuthRequest userAuthRequest = request.getData();

        User user = User.builder()
                    .userSeq( userAuthRequest.getUserSeq() )
                    .authCode( user );

        User user = new User();

        User getUser = userRepository.findByEmailAndAuthCode( user );

        return Header.OK( getUser );
    }
    */
}


