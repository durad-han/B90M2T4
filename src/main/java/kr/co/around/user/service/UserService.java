package kr.co.around.user.service;

import java.util.Map;

import kr.co.around.repository.vo.UserVO;

public interface UserService {
	
	public Map<String,Object> easySign(UserVO userVO) throws Exception;

}
