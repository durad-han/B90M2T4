package kr.co.around.card.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.around.repository.mapper.CardMapper;
import kr.co.around.repository.vo.HashtagVO;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardMapper cMapper;

	@Override
	public void insertCard() throws Exception {
		System.out.println("Service : insertCard");
	}

	@Override
	public void updateCard() throws Exception {
		System.out.println("Service : updateCard");
		
	}

	@Override
	public void deleteCard() throws Exception {
		System.out.println("Service : deleteCard");
		
	}

	@Override
	public void retrieveCardList() throws Exception {
		System.out.println("Service : retrieveCardList");
		
	}

	@Override
	public void retrieveCard() throws Exception {
		System.out.println("Service : retrieveCard");
		
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
