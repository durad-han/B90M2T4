package kr.co.around.card.service;

import java.util.List;
import java.util.Map;

import kr.co.around.repository.vo.*;

public interface CardService {
	
//----- 카드 조회 관련 -----------------------------------------------------------------------	
	public CardVO retrieveCard(int cardSeq) throws Exception;
	
	public Map<String, Object> retrieveCardList(SearchVO search) throws Exception;

	public Map<String, Object> retrieveCommentList(SearchVO search) throws Exception;

	
//----- 카드 수정, 삭제 관련 ------------------------------------------------------------------
	public void updateCard(int cardSeq) throws Exception;
	
	public void updateCardForm() throws Exception;
	
	public void deleteCard(int cardSeq) throws Exception;

	
//----- 카드 입력 관련 -----------------------------------------------------------------------
	public void insertComment(CommentVO commentVO) throws Exception;
	
	public void insertCard(CardVO CardVO) throws Exception;

	public void insertCardForm() throws Exception;
	
	public List<HashtagVO> retrieveHashtag(String hashtagInput) throws Exception;


}
