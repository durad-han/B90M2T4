package kr.co.around.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.around.repository.mapper.CardMapper;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardMapper cardMapper;
}
