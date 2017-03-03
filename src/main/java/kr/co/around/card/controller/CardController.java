package kr.co.around.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.around.card.service.CardService;

@Controller
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private CardService cs;
	
	@RequestMapping("/retrieve.do")
	public void retrieveCard(){
		System.out.println("retrieveCard");
		cs.retrieveCard();
//		return "/card/retrieveCard";
	}
	
	@RequestMapping("/retrieveList.do")
	public void retrieveCardList(){
		System.out.println("retrieveCard");
		cs.retrieveCardList();
	}
	
	@RequestMapping("/insert.do")
	public void insertCard(){
		System.out.println("insertCard");
		cs.insertCard();
	}
	
	@RequestMapping("/insertForm.do")
	public void insertCardForm(){
		System.out.println("insertCardForm");
		cs.insertCardForm();
	}
	
	@RequestMapping("/update.do")
	public void updateCard(){
		System.out.println("updateCard");
		cs.updateCard();
	}
	
	@RequestMapping("/updateForm.do")
	public void updateCardForm(){
		System.out.println("updateCardForm");
		cs.updateCardForm();
	}
	
	@RequestMapping("/delete.do")
	public void deleteCard(){
		System.out.println("deleteCard");
		cs.deleteCard();
	}

}
