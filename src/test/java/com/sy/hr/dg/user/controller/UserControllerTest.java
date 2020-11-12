package com.sy.hr.dg.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sy.hr.dg.DgApplicationTests;
import com.sy.hr.dg.user.service.UserService;
import org.junit.Before;
import org.junit.Test;
import com.sy.hr.dg.user.vo.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    @AutoConfigureMockMvc
//@WebMvcTest

    @RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
    public class UserControllerTest {

        //@Autowired
        private MockMvc mockMvc;

        @MockBean
    private UserService userService;

    //@Autowired
    //private UserController userController;

    @Autowired
    private WebApplicationContext wac;


    @Before
    public void setup() {
        //스프링이 준 WebApplicationContext를 이용해서 mockmvc를 생성
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
       // logger.debug("setup BoardControllerTest mockMvc...");
    }

    @Test
    public void test() throws Exception {
        //when( userService.doubleCheckEmail( "j@abc.com" ) ).thenReturn( 9L );

        this.mockMvc.perform( get( "/doubleCheckEmail" )
                .param( "email", "j@abc.com" ))
                .andExpect( status().isOk() )
                //.andExpect( content().string( equalTo( 5 ) ) )
                .andDo( print() );
    }

    @Test
    public void test2() throws Exception {

    }

}
