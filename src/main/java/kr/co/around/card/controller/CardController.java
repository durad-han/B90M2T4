package kr.co.around.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.around.card.service.CardService;
import kr.co.around.repository.vo.HashtagVO;

@Controller
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private CardService cs;
	
	@RequestMapping("/retrieve.do")
	public void retrieveCard(@RequestParam("no")int cardSeq, Model model) throws Exception {
		System.out.println("retrieveCard");
		System.out.println("cardSeq : " + cardSeq);
		model.addAttribute("card", cs.retrieveCard(cardSeq));
	}
	
	@RequestMapping("/retrieveList.do")
	public void retrieveCardList() throws Exception {
		System.out.println("retrieveCard");
		cs.retrieveCardList();
	}
	
	@RequestMapping("/insert.do")
	public void insertCard() throws Exception {
		System.out.println("insertCard");
		cs.insertCard();
	}
	
	@RequestMapping("/insertForm.do")
	public void insertCardForm() throws Exception {
		System.out.println("insertCardForm");
		cs.insertCardForm();
	}
	
	@RequestMapping("/update.do")
	public void updateCard() throws Exception {
		System.out.println("updateCard");
		cs.updateCard(0);
	}
	
	@RequestMapping("/updateForm.do")
	public void updateCardForm() throws Exception {
		System.out.println("updateCardForm");
		cs.updateCardForm();
	}
	
	@RequestMapping("/delete.do")
	public void deleteCard() throws Exception {
		System.out.println("deleteCard");
		cs.deleteCard(0);
	}
	
	@RequestMapping("/retrieveHashtag.do")
	public List<HashtagVO> retrieveHashtag(String hashtagInput) throws Exception {
		System.out.println("retrieveHashtag");
		return cs.retrieveHashtag(hashtagInput);
	}

}
