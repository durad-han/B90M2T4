package kr.co.around.repository.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CardMapper {
	
	@Autowired
	 private SqlSessionTemplate session;
	
}
