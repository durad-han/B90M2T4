package kr.co.around.card.service;

import java.util.List;

import kr.co.around.repository.vo.CardVO;
import kr.co.around.repository.vo.HashtagVO;

public interface CardService {

	public void insertCard() throws Exception;

	public void updateCard(int cardSeq) throws Exception;

	public void deleteCard(int cardSeq) throws Exception;

	public List<CardVO> retrieveCardList() throws Exception;

	public CardVO retrieveCard(int cardSeq) throws Exception;

	public void updateCardForm() throws Exception;

	public void insertCardForm() throws Exception;
	
	public List<HashtagVO> retrieveHashtag(String hashtagInput) throws Exception;

}
