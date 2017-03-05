package kr.co.around.card.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.around.card.service.CardService;
import kr.co.around.repository.vo.CardVO;
import kr.co.around.repository.vo.HashtagVO;

@Controller
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private CardService cs;
	
	@RequestMapping("/retrieve.do")
	public CardVO retrieveCard(@RequestParam("no")int cardSeq) throws Exception {
		System.out.println("retrieveCard");
		System.out.println("cardSeq : " + cardSeq);
		CardVO card = cs.retrieveCard(cardSeq);
		System.out.println("retrieveCard return Content : " + card.getCardContent());
		return card;
	}
	
	@RequestMapping("/retrieveList.do")
	public List<CardVO> retrieveCardList() throws Exception {
		System.out.println("retrieveCardList");
		return cs.retrieveCardList();
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
	public List<HashtagVO> retrieveHashtag(HttpServletRequest request) throws Exception {
		System.out.println("retrieveHashtag");
		String hashtagInput = request.getParameter("hashtagInput");
		System.out.println(hashtagInput);
		hashtagInput = hashtagInput.substring(1);
		System.out.println(hashtagInput);
		List<HashtagVO> list = cs.retrieveHashtag(hashtagInput);
		System.out.println(list.size());
		
		return list;
	}

}
