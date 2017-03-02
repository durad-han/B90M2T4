package kr.co.around.card.service;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.around.repository.mapper.CardMapper;

public class CardServiceImpl implements CardService {

	@Autowired
	private CardMapper cardMapper;
}
