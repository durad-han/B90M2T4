package kr.co.around.card.service;

import java.util.List;

import kr.co.around.repository.vo.HashtagVO;

public interface CardService {

	void insertCard() throws Exception;

	void updateCard() throws Exception;

	void deleteCard() throws Exception;

	void retrieveCardList() throws Exception;

	void retrieveCard() throws Exception;

	void updateCardForm() throws Exception;

	void insertCardForm() throws Exception;
	
	public List<HashtagVO> retrieveHashtag(String hashtagInput) throws Exception;

}
