package kr.co.around.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.co.around.login.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService ls;
	
	

}
