package kr.co.around.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.co.around.card.service.CardService;

@Controller
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	

}
