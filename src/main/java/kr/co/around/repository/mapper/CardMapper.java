package kr.co.around.repository.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.around.repository.vo.*;

@Repository
public interface CardMapper {
	
//----- 카드 조회 관련 -----------------------------------------------------------------------	
	public CardVO selectCardSeq(int cardSeq) throws Exception;
	
	public List<CardVO> selectCardList() throws Exception;
	
	public int selectCardCount(SearchVO search) throws Exception;
	
	
	public List<CommentVO> selectCommentList(int cardSeq) throws Exception;
	
	public int selectCommentCount(SearchVO search) throws Exception;
	
	
//----- 카드 수정, 삭제 관련 ------------------------------------------------------------------
	
	
	
//----- 카드 입력 관련 -----------------------------------------------------------------------
	public List<HashtagVO> selectHashtag(String hashtagInput) throws Exception;
	
	
}
