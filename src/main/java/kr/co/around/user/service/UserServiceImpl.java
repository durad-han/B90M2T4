package kr.co.around.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.around.repository.mapper.UserMapper;
import kr.co.around.repository.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper dao;

	@Override
	public int insertUser(UserVO userVO) throws Exception {
		return dao.insertUser(userVO);
	}
	
	@Override
	public UserVO selectUser(UserVO userVO) throws Exception {
		return dao.selectUser(userVO);
	}

	@Override
	public UserVO selectUserSeq(int userSeq) throws Exception {
		return dao.selectUserSeq(userSeq);
	}
	
}
