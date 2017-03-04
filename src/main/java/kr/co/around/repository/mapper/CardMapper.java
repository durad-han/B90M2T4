package kr.co.around.repository.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.around.repository.vo.HashtagVO;

@Repository
public interface CardMapper {
	
	/* =================================================== */
	/* 해시 태그 관련                                        */
	/* =================================================== */
	
	public List<HashtagVO> selectHashtag(String hashtagInput) throws Exception;
	
	
}
