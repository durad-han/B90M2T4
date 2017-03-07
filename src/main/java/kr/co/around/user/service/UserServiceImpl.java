package kr.co.around.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.around.repository.mapper.UserMapper;
import kr.co.around.repository.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper dao;
	
	@Override
	public Map<String,Object> easySign(UserVO userVO) throws Exception {
		
		Map<String,Object> map = new HashMap<>();
		
		UserVO rsltUserVO;

		// 회원가입 여부 조회 
		if(userVO.getType() == "kakao") {
			System.out.println("카카오 : " + userVO.getUserKey());
			rsltUserVO = dao.selectUser(userVO);
		} else {
			System.out.println("구글 : " + userVO.getUserId());
			rsltUserVO = dao.selectUser(userVO);
			System.out.println("restulrVO는?");
		} 
		
		
		if(rsltUserVO == null) {
			
			// 회원가입 
			System.out.println("서비스 시작");
			map.put("user", dao.selectUserSeq(dao.insertUser(userVO)));
			System.out.println("서비스 끝");
			map.put("msg", "signUp");
			
		} else {
			
			if(rsltUserVO.getUserId().equals(userVO.getUserId())) {
				// 로그인
				map.put("user", rsltUserVO);
				map.put("msg", "signIn");
			} else {
				// 카카오 계정 바르게 써달라고 안내
				map.put("user", rsltUserVO);
				map.put("msg", "info");
			}

		}
		
		return map;
	}
	

}
