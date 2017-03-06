package kr.co.around.card.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.around.repository.mapper.CardMapper;
import kr.co.around.repository.vo.*;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardMapper cMapper;
	
//----- 카드 조회 관련 -----------------------------------------------------------------------	
	@Override
	public CardVO retrieveCard(int cardSeq) throws Exception {
		CardVO card =  cMapper.selectCardSeq(cardSeq);
		return card;
	}

	@Override
	public Map<String, Object> retrieveCardList(SearchVO search) throws Exception {
		Map<String, Object> cardMap = new HashMap<String, Object>();
			cardMap.put("cardList", cMapper.selectCardList());
			cardMap.put("pageResult", cMapper.selectCardCount(search));
		return cardMap;
		
	}

	@Override
	public Map<String, Object> retrieveCommentList(int cardSeq, SearchVO search) throws Exception {
		Map<String, Object> commentMap = new HashMap<String, Object>();
			commentMap.put("commentList", cMapper.selectCommentList(cardSeq));
			commentMap.put("pageResult", cMapper.selectCommentCount(search));
		return commentMap;
	}
	
	
//----- 카드 수정, 삭제 관련 ------------------------------------------------------------------
	
	@Override
	public void updateCard(int cardSeq) throws Exception {
		System.out.println("Service : updateCard");
		
	}
	
	@Override
	public void updateCardForm() throws Exception {
		System.out.println("Service : updateCardForm");
		
	}
	
	@Override
	public void deleteCard(int cardSeq) throws Exception {
		System.out.println("Service : deleteCard");
		
	}


//----- 카드 입력 관련 -----------------------------------------------------------------------
	@Override
	public void insertCard() throws Exception {
		System.out.println("Service : insertCard");
	}
	
	@Override
	public void insertCardForm() throws Exception {
		System.out.println("Service : insertCardForm");
		
	}
	
	@Override
	public List<HashtagVO> retrieveHashtag(String hashtagInput) throws Exception {
		System.out.println("Service : retrieveHashtag");
		List<HashtagVO> HashtagVO = cMapper.selectHashtag(hashtagInput);
		System.out.println(HashtagVO);
		return HashtagVO;
	}

	
}
