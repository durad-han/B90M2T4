package kr.co.around.myFavorite.service;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.around.repository.mapper.MyFavoriteMapper;

public class MyFavoriteServiceImpl implements MyFavoriteService {

	@Autowired
	private MyFavoriteMapper myFavoriteMapper;
}
