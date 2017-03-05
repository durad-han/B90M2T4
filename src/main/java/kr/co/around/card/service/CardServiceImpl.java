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
		System.out.println("Service : retrieveCardList");
		return null;
		
	}

	@Override
	public CardVO retrieveCard(int cardSeq) throws Exception {
		System.out.println("Service : retrieveCard");
		System.out.println("cardSeq : " + cardSeq);
		CardVO temp = tMapper.selectCardSeq(cardSeq);
		
		CardVO card =  cMapper.selectCardSeq(cardSeq);
		if(temp != null){
			System.out.println(card.getCardContent());
		}else{
			System.out.println("널값 날아옴");
		}
		return null;
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
