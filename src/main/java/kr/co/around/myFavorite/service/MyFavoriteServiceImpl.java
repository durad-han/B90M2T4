package kr.co.around.myFavorite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.around.repository.mapper.MyFavoriteMapper;

@Service
public class MyFavoriteServiceImpl implements MyFavoriteService {

	@Autowired
	private MyFavoriteMapper myMapper;
}
