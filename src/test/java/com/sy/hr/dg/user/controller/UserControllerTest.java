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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@AutoConfigureMockMvc
@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    /*@Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(UserController.class)
                .alwaysExpect(status().isOk())
                .build();
    }*/

    @Test
    public void test() throws Exception {
        //when( userService.doubleCheckEmail( "j@abc.com" ) ).thenReturn( 10L );

        mockMvc.perform( get( "/doubleCheckEmail" )
                .param( "email", "j@abc.com" ))
                .andExpect( status().isOk() )
                //.andExpect( content().string( equalTo( 5 ) ) )
                .andDo( print() );


                //.andExpect( content().toString() )

    }
//
//    optionalCategory.ifPresent(c -> {
//        User.assertEquals(c.getType(),type);
//        System.out.println(c.getId());


}
