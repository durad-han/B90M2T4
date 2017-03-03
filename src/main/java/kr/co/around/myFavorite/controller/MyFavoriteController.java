package kr.co.around.myFavorite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.co.around.myFavorite.service.MyFavoriteService;

@Controller
public class MyFavoriteController {
	
	@Autowired
	private MyFavoriteService mys;
	
	

}
