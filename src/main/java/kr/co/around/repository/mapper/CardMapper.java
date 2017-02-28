package kr.co.around.repository.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.around.common.db.MyAppSqlConfig;

@Repository
public class CardMapper {
	
	private SqlSession sqlMapper;
	public CardMapper(){
		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	}

	
	
	
	
	
	
	
}
