package com.sy.hr.dg.user.repository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sy.hr.dg.DgApplicationTests;
import com.sy.hr.dg.user.controller.UserController;
import com.sy.hr.dg.user.vo.User;

public class UserRepositoryTest extends DgApplicationTests {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserController userController;
    
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;

	/*
	 * @Test public void create() { User user = new User(); user.setUserName("ÁÖÇý¸²");
	 * user.setEmail("j@abc.com"); user.setNickname("Joo");
	 * user.setPassword("dream1004!"); user.setMobile(01000001111);
	 * user.setRegDate(LocalDateTime.now()); user.setUpdtDate(LocalDateTime.now());
	 * user.setSuccessCount(0); user.setTryCount(0);
	 * 
	 * User newUser = userRepository.save(user);
	 * 
	 * System.out.println( newUser ); }
	 */

    @Test
    public void save() throws Exception {
    	User user = new User();
    	user.setUserName("Á¤¼­¿¬");
   	 	user.setEmail("seoyeon@aa.bb.com");
   	 	user.setNickname("seoyeon");
   	 	user.setPassword("dream1004!");
   	 	user.setMobile(01011112222);
   	 	user.setRegDate(LocalDateTime.now());
   	 	user.setUpdtDate(LocalDateTime.now());
   	 	user.setSuccessCount(0);
   	 	user.setTryCount(0);
   	 	
   	 	System.out.println( "user >>> " + toJsonString( user ) );
    	
    	mockMvc = MockMvcBuilders.standaloneSetup( userController ).build();
    	
    	mockMvc.perform(
    			MockMvcRequestBuilders.post( "/user/save" )
    			.contentType( MediaType.APPLICATION_JSON_UTF8 )
    			.content( toJsonString( user ) )
    	).andDo( MockMvcResultHandlers.print() )
    	.andExpect( status().isOk() );
    }
    
    @Test
    public void checkJsonString() throws JsonProcessingException {
    	User user = new User();
    	user.setUserName("ÁÖÇý¸²");
   	 	user.setEmail("j@abc.com");
   	 	user.setNickname("Joo");
   	 	user.setPassword("dream1004!");
   	 	user.setMobile(01000001111);
   	 	user.setRegDate(LocalDateTime.now());
   	 	user.setUpdtDate(LocalDateTime.now());
   	 	user.setSuccessCount(0);
   	 	user.setTryCount(0);
   	 	
   	 	System.out.println( toJsonString( user ) );
    }
    
    public String toJsonString( User user ) throws JsonProcessingException {
    	return objectMapper.writeValueAsString( user );
    }
    
    
}
