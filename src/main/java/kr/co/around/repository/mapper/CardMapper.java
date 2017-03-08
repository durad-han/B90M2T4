package kr.co.around.repository.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.around.repository.vo.*;

@Repository
public interface CardMapper {
	
//----- 카드 조회 관련 -----------------------------------------------------------------------	
	public CardVO selectCardSeq(int cardSeq) throws Exception;
	
	public List<CardVO> selectCardList(SearchVO search) throws Exception;
	
	public int selectCardCount(SearchVO search) throws Exception;
	
	
	public List<CommentVO> selectCommentList(SearchVO search) throws Exception;
	
	public int selectCommentCount(SearchVO search) throws Exception;
	
	
//----- 카드 수정, 삭제 관련 ------------------------------------------------------------------
	
	
	
//----- 카드 입력 관련 -----------------------------------------------------------------------
	public void insertComment(CommentVO commentVO) throws Exception;
	
	public void insertCard(CardVO CardVO) throws Exception;

	public List<HashtagVO> selectHashtag(String hashtagInput) throws Exception;

	
	
}
