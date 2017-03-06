package kr.co.around.card.service;

import java.util.List;

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
//		카드 리턴값 확인용 코드
//		if(card != null){
//			System.out.println("one service : 값이 있다");
//			System.out.println("one card content : " + card.getCardContent());
//		}else{
//			System.out.println("one service : 널값 날아옴");
//		}
		return card;
	}

	@Override
	public List<CardVO> retrieveCardList() throws Exception {
		return cMapper.selectCardList();
		
	}

	@Override
	public List<CommentVO> retrieveCommentList(int cardSeq) throws Exception {
		List<CommentVO> cList = cMapper.selectCommentList(cardSeq);
//		디버그용 코멘트 리스트 확인
//		if(cList != null){
//			System.out.println("cList service : 값이 있다");
//			System.out.println("cList content : " + cList.get(0).getCommentContent());
//		}else{
//			System.out.println("cList service : 널값 날아옴");
//		}
		return cList;
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
