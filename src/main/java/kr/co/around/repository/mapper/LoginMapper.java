package kr.co.around.repository.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.around.repository.vo.UserVO;

@Repository
public class LoginMapper {
	
	@Autowired
	private SqlSessionTemplate sqlMapper;
	
	public int insertUser(UserVO user) {
		sqlMapper.insert(
				"kr.co.mlec.repository.mapper.LoginMapper.insertUser", user);
		return user.getUserSeq();
		
	}
	
	public UserVO selectUser(String id) {
		return sqlMapper.selectOne(
				"kr.co.mlec.repository.mapper.LoginMapper.selectUser", id);
	}
	
	public UserVO selectUserSeq(int userSeq) {
		return sqlMapper.selectOne(
				"kr.co.mlec.repository.mapper.LoginMapper.selectUserSeq", userSeq);
	}
	
}
