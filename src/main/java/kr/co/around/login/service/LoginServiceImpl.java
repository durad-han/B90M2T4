package kr.co.around.login.service;

import org.springframework.stereotype.Service;

import kr.co.around.repository.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {

	private LoginMapper loginMapper;
}
