//package com.springboot.blog.springbootrestap.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.springboot.blog.springbootrestap.payload.LoginDto;
//import com.springboot.blog.springbootrestap.payload.SignupDto;
//
//@RestController
//@RequestMapping
//public class UserController {
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	
//	@PostMapping("/login")
//	public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto)
//	{
//		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword()));
//		
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		return new ResponseEntity<>("Successfully signin",HttpStatus.OK);
//		
//	}
//	
//	@PostMapping("/signup")
//	public ResponseEntity<String> registerUser(@RequestBody SignupDto signupDto)
//	{
//		
//		
//	}
//	
//
//}
