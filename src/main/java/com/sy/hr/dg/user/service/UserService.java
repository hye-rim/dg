package com.sy.hr.dg.user.service;

import com.sy.hr.dg.model.network.Header;
import com.sy.hr.dg.model.network.request.user.UserReadForEmailRequest;
import com.sy.hr.dg.model.network.request.user.UserRegistRequest;
import com.sy.hr.dg.model.network.response.user.UserReadForEmailResponse;
import com.sy.hr.dg.user.repository.UserRepository;
import com.sy.hr.dg.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.sy.hr.dg.model.network.Header.OK;

@Service
@Slf4j
/**
 * @className UserService
 */
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @method doubleCheckEmail
     * @author dream
     * @since 2020-11-13
     * @params
     * @return
     */
    public Long doubleCheckEmail(String email) {
        System.out.println("UserService 진입");

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

    public Header<UserReadForEmailResponse> readUser( String email ) {
        log.info("readUser email => {}", email);

        UserReadForEmailResponse user = userRepository.findByEmail( email );

        return Header.OK(user);
    }
}


