package kr.co.around.myFavorite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.around.myFavorite.service.MyFavoriteService;

@Controller
@RequestMapping("/my")
public class MyFavoriteController {
	
	@Autowired
	private MyFavoriteService mys;
	
	

}
