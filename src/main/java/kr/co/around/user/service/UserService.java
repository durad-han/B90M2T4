package kr.co.around.user.service;

import kr.co.around.repository.vo.UserVO;

public interface UserService {
	
	public UserVO selectUser(UserVO userVO) throws Exception;
	public int insertUser(UserVO userVO) throws Exception;
	public UserVO selectUserSeq(int userSeq) throws Exception;

}
