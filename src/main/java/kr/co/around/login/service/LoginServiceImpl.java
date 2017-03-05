package kr.co.around.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.around.repository.mapper.LoginMapper;
import kr.co.around.repository.vo.UserVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Override
	public int insertUser(UserVO userVO) throws Exception {
		return loginMapper.insertUser(userVO);
	}
	
	@Override
	public UserVO selectUser(String id) throws Exception {
		return loginMapper.selectUser(id);
	}

	@Override
	public UserVO selectUserSeq(int userSeq) throws Exception {
		return loginMapper.selectUserSeq(userSeq);
	}
	
}
