package kr.co.around.repository.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.around.repository.vo.CardVO;

@Repository
public class TempMapper {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public CardVO selectCardSeq(int cardSeq){
		System.out.println("cardSeq : " + cardSeq);
		CardVO temp = session.selectOne("kr.co.around.repository.mapper.CardMapper.selectCardSeq");
		if(temp != null){
			System.out.println(temp.getCardContent());
		}else{
			System.out.println("널값 날아옴");
		}
		return null;
	}

}
