package kr.co.around.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.co.around.repository.mapper.CardMapper;

@Controller
public class CardController {
	@Autowired
	private CardMapper mapper;
	
	

}
