package kr.co.around.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.around.repository.vo.UserVO;
import kr.co.around.user.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService ls;
	
	@ResponseBody
	@RequestMapping("/signUp.do")
	public String signUp(UserVO userVO, HttpSession session) throws Exception {
		String msg;
		UserVO user = ls.selectUser(userVO);
		if(user == null) {
			int seq = ls.insertUser(userVO);
			user = ls.selectUserSeq(seq);
			msg = "OK";
		} else {
			msg = "LOGIN";
		}
		
		session.setAttribute("user", user);
		return msg;
	}
	
	@ResponseBody
	@RequestMapping("/signIn.do")
	public String signIn(UserVO userVO, HttpSession session) throws Exception {
		String msg;
		UserVO user = ls.selectUser(userVO);

		msg = "OK";
		if(user == null) {
			msg = "SIGNUP";
		} 
		session.setAttribute("user", user);
		return msg;
	}
	

}
