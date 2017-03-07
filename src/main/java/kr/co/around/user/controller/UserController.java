package kr.co.around.user.controller;

import java.util.Map;

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
	@RequestMapping("/easySign.do")
	public Map<String, Object> easySign(UserVO userVO, HttpSession session) throws Exception {
		
		Map<String, Object> map = ls.easySign(userVO);
		session.setAttribute("user", map.get("user"));
		
		return map;
	}
	
	

}
