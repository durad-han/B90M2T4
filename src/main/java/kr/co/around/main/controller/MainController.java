package kr.co.around.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.around.main.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService ms;
	
	@RequestMapping("/main/main.do")
	public void main() throws Exception {}
	
	
}