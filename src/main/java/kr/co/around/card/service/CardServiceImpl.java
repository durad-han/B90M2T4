package kr.co.around.card.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.around.repository.mapper.CardMapper;
import kr.co.around.repository.mapper.TempMapper;
import kr.co.around.repository.vo.CardVO;
import kr.co.around.repository.vo.HashtagVO;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardMapper cMapper;
	@Autowired
	private TempMapper tMapper;
	

	@Override
	public void insertCard() throws Exception {
		System.out.println("Service : insertCard");
	}

	@Override
	public void updateCard(int cardSeq) throws Exception {
		System.out.println("Service : updateCard");
		
	}

	@Override
	public void deleteCard(int cardSeq) throws Exception {
		System.out.println("Service : deleteCard");
		
	}

	@Override
	public List<CardVO> retrieveCardList() throws Exception {
		System.out.println("list Service : retrieveCardList");
		List<CardVO> list = cMapper.selectCardList();
//		if(list == null){
//			System.out.println("list service : 널값 날아옴");
//		}else{
//			System.out.println("list service : 값이 있다");
//			CardVO sample = list.get(0);
//			System.out.println("list card seq :" + sample.getCardSeq());
//			System.out.println("list card user :" + sample.getUserSeq());
//			System.out.println("list card content :" + sample.getCardContent());
//			System.out.println("list card feeling :" + sample.getCardFeeling());
//			System.out.println("list card longitude :" + sample.getCardLongitude());
//			System.out.println("list card latitude :" + sample.getCardLatitude());
//			System.out.println("list card hashtag :" + sample.getCardHashtag());
//			System.out.println("list card regDate :" + sample.getCardRegDate());
//		}
		return list;
		
	}

	@Override
	public CardVO retrieveCard(int cardSeq) throws Exception {
		System.out.println("one Service : retrieveCard");
//		System.out.println("one Service : cardSeq : " + cardSeq);
//		CardVO temp = tMapper.selectCardSeq(cardSeq);
//		
//		CardVO card =  cMapper.selectCardSeq(cardSeq);
//		if(temp != null){
//			System.out.println("one service : 값이 있다");
//			System.out.println("one card content : " + card.getCardContent());
//		}else{
//			System.out.println("one service : 널값 날아옴");
//		}
		
		List<CardVO> list = cMapper.selectCardList();
		return list.get(cardSeq-1);
	}

	@Override
	public void updateCardForm() throws Exception {
		System.out.println("Service : updateCardForm");
		
	}

	@Override
	public void insertCardForm() throws Exception {
		System.out.println("Service : insertCardForm");
		
	}

	@Override
	public List<HashtagVO> retrieveHashtag(String hashtagInput) throws Exception {
		System.out.println("Service : retrieveHashtag");
		return cMapper.selectHashtag(hashtagInput);
	}
	
}
