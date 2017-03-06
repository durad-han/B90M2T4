package kr.co.around.card.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.around.card.service.CardService;
import kr.co.around.repository.vo.CardVO;
import kr.co.around.repository.vo.CommentVO;
import kr.co.around.repository.vo.HashtagVO;

@Controller
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private CardService cs;
	
//----- 카드 조회 관련 -----------------------------------------------------------------------	
	@RequestMapping("/retrieve.json")
	@ResponseBody
	public CardVO retrieveCard(@RequestParam("no")int cardSeq) throws Exception {
		return cs.retrieveCard(cardSeq);
	}
	
	@RequestMapping("/retrieveList.json")
	@ResponseBody
	public List<CardVO> retrieveCardList() throws Exception {
		return cs.retrieveCardList();
	}
	
	@RequestMapping("/retrieveCommentList.json")
	@ResponseBody
	public List<CommentVO> retrieveCommentList(@RequestParam("no")int cardSeq) throws Exception {
		List<CommentVO> cList = cs.retrieveCommentList(cardSeq);
//		디버그용 코멘트 리스트 확인
//		for(CommentVO com : cList){
//			System.out.println(com.getCommentContent());
//		}
		return cList;
	}
	
	
	
	
//----- 카드 수정, 삭제 관련 ------------------------------------------------------------------
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
	
	
//----- 카드 입력 관련 -----------------------------------------------------------------------
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
	
	@RequestMapping("/retrieveHashtag.do")
	public List<HashtagVO> retrieveHashtag(HttpServletRequest request) throws Exception {
		System.out.println("retrieveHashtag");
		String hashtagInput = request.getParameter("hashtagInput");
		System.out.println(hashtagInput);
		if(hashtagInput.startsWith("#")) {
			hashtagInput = hashtagInput.substring(1);
		}
		System.out.println(hashtagInput);
		List<HashtagVO> list = cs.retrieveHashtag(hashtagInput);
		System.out.println(list.size());
		
		return list;
	}

}
