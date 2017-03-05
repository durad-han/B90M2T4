package kr.co.around.repository.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.around.repository.vo.CardVO;
import kr.co.around.repository.vo.HashtagVO;

@Repository
public interface CardMapper {
	
//----- 카드 조회 --------------------------------------------------------------------------
	public CardVO selectCardSeq(int cardSeq) throws Exception;
	
	public List<CardVO> selectCardList() throws Exception;
	
	
//----- 해시태그 --------------------------------------------------------------------------
	public List<HashtagVO> selectHashtag(String hashtagInput) throws Exception;
	
	
}
