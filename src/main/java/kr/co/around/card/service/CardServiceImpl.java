package kr.co.around.card.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.around.comm.util.DistanceUtil;
import kr.co.around.repository.mapper.CardMapper;
import kr.co.around.repository.vo.*;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardMapper cMapper;
	
//----- 카드 조회 관련 -----------------------------------------------------------------------	
	@Override
	public CardVO retrieveCard(int cardSeq) throws Exception {
		CardVO card =  cMapper.selectCardSeq(cardSeq);
		return card;
	}

	@Override
	public Map<String, Object> retrieveCardList(SearchVO search) throws Exception {
		Map<String, Object> cardMap = new HashMap<String, Object>();
		List<CardVO> cardList = cMapper.selectCardList(search);
		List<CardVO> markerList = cMapper.selectMarkerList();
		
		List<CardVO> removedCardList = new ArrayList<>();
		List<CardVO> removedMarkerList = new ArrayList<>();
		
/*		for(int i = 0; i < cardList.size(); i++) {
			// 미터(Meter) 단위
			CardVO cardItem = cardList.get(i);
			double distance = DistanceUtil.distance(37.4944104, 127.0279339, cardItem.getCardLatitude(), cardItem.getCardLongitude(), "meter");
			cardItem.setDistance(distance);
	        if(distance <= search.getDistance()) {
				System.out.println("distance : " + i + " 번째 " + distance);
				removedCardList.add(cardItem);
			}
		}*/
		
		for(int i = 0; i < markerList.size(); i++) {
			
			CardVO marker = markerList.get(i);
			double distance = DistanceUtil.distance(37.4944104, 127.0279339, marker.getCardLatitude(), marker.getCardLongitude(), "meter");
			marker.setDistance(distance);
			if(distance <= search.getDistance()) {
				System.out.println("distance : " + i + " 번째 " + distance);
				removedMarkerList.add(marker);
			}
		}
			
		cardMap.put("cardList", cardList);
		cardMap.put("pageResult", new PageResultVO(search.getPageNo(), cMapper.selectCardCount(search)));
		cardMap.put("markerList", removedMarkerList);
		return cardMap;
		
	}

	@Override
	public Map<String, Object> retrieveCommentList(SearchVO search) throws Exception {
		Map<String, Object> commentMap = new HashMap<String, Object>();
			commentMap.put("commentList", cMapper.selectCommentList(search));
			commentMap.put("pageResult", new PageResultVO(search.getPageNo(), cMapper.selectCommentCount(search)));
		return commentMap;
	}
	
	
	
//----- 카드 수정, 삭제 관련 ------------------------------------------------------------------
	
	@Override
	public void updateCard(int cardSeq) throws Exception {
		System.out.println("Service : updateCard");
		
	}
	
	@Override
	public void updateCardForm() throws Exception {
		System.out.println("Service : updateCardForm");
		
	}
	
	@Override
	public void deleteCard(int cardSeq) throws Exception {
		System.out.println("Service : deleteCard");
		
	}


//----- 카드 입력 관련 -----------------------------------------------------------------------
	@Override
	public void insertComment(CommentVO commentVO) throws Exception {
		cMapper.insertComment(commentVO);
		System.out.println("Service : insertComment");
	}
	
	@Override
	public void insertCard(CardVO cardVO) throws Exception {
		cMapper.insertCard(cardVO);
		System.out.println("Service : insertCard");
	}
	
	@Override
	public void insertCardForm() throws Exception {
		System.out.println("Service : insertCardForm");
		
	}
	
	@Override
	public List<HashtagVO> retrieveHashtag(String hashtagInput) throws Exception {
		System.out.println("Service : retrieveHashtag");
		List<HashtagVO> HashtagVO = cMapper.selectHashtag(hashtagInput);
		System.out.println(HashtagVO);
		return HashtagVO;
	}
	
	@Override
	public List<HashtagVO> selectAllHashtag() throws Exception {
		System.out.println("Service : selectAllHashtag");
		List<HashtagVO> allHashTagVO = cMapper.selectAllHashtag();
		return allHashTagVO;
	}
	
	@Override
	public void insertHashtag(String hashtagContent) throws Exception {
		System.out.println("Service : insertHashTag");
		cMapper.insertHashtag(hashtagContent);
	}

}
