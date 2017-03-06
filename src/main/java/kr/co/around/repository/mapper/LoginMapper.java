package kr.co.around.repository.mapper;

import org.springframework.stereotype.Repository;

import kr.co.around.repository.vo.UserVO;

@Repository
public interface LoginMapper {
	
	public int insertUser(UserVO user);
	
	public UserVO selectUser(String id);
	
	public UserVO selectUserSeq(int userSeq);
	
}
