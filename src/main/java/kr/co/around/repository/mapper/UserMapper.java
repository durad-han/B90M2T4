package kr.co.around.repository.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.around.repository.vo.UserVO;

@Repository
public class UserMapper {
	
	@Autowired
	private SqlSessionTemplate sqlMapper;
	
	public UserVO selectUser(UserVO user) {
		System.out.println("매퍼 SELECT : " + user);
		return sqlMapper.selectOne(
				"kr.co.around.repository.mapper.UserMapper.selectUser", user);
	}
	
	public UserVO selectUserSeq(int userSeq) {
		return sqlMapper.selectOne(
				"kr.co.around.repository.mapper.UserMapper.selectUserSeq", userSeq);
	}
	
	public int insertUser(UserVO user) {
		System.out.println("매퍼 시작");
		sqlMapper.insert(
				"kr.co.around.repository.mapper.UserMapper.insertUser", user);
		System.out.println("매퍼 끝");
		return user.getUserSeq();
		
	}
	
}
