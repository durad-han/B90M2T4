package kr.co.around.login.service;

import kr.co.around.repository.vo.UserVO;

public interface LoginService {
	
	public UserVO selectUser(String id) throws Exception;
	public int insertUser(UserVO userVO) throws Exception;
	public UserVO selectUserSeq(int userSeq) throws Exception;

}
