package kr.co.around.repository.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.around.repository.vo.CardVO;
import kr.co.around.repository.vo.HashtagVO;

@Repository
public interface CardMapper {
	
	public CardVO selectCardSeq(int cardSeq) throws Exception;
	
	/* =================================================== */
	/* 해시 태그 관련                                     				   */
	/* =================================================== */
	
	public List<HashtagVO> selectHashtag(String hashtagInput) throws Exception;
	
	
}
