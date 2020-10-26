package com.sy.hr.dg.user.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sy.hr.dg.user.service.UserService;
import com.sy.hr.dg.user.vo.User;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<User> save( User user ) {
		return new ResponseEntity<User>( userService.save( user ), HttpStatus.OK );
	}
	
	@PutMapping("/doubleCheckEmail/{email}")
	public ResponseEntity<User> doubleCheckEmail( @PathVariable("email") String email ) {
		Optional<User> user = userService.findByEmail( email );
		
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
	}
	
}
