package kr.co.around.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.around.login.service.LoginService;
import kr.co.around.repository.vo.UserVO;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Autowired
	private LoginService ls;
	
	@ResponseBody
	@RequestMapping("/signUp.do")
	public String signUp(UserVO userVO, HttpSession session) throws Exception {
		String msg;
		UserVO user = ls.selectUser(userVO.getUserId());
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
	

}
