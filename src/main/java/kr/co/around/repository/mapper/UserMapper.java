package kr.co.around.repository.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.around.repository.vo.UserVO;

@Repository
public class UserMapper {
	
	@Autowired
	private SqlSessionTemplate sqlMapper;
	
	public int insertUser(UserVO user) {
		sqlMapper.insert(
				"kr.co.mlec.repository.mapper.UserMapper.insertUser", user);
		return user.getUserSeq();
		
	}
	
	public UserVO selectUser(UserVO user) {
		return sqlMapper.selectOne(
				"kr.co.mlec.repository.mapper.UserMapper.selectUser", user);
	}
	
	public UserVO selectUserSeq(int userSeq) {
		return sqlMapper.selectOne(
				"kr.co.mlec.repository.mapper.UserMapper.selectUserSeq", userSeq);
	}
	
}
