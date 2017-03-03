package kr.co.around.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.around.repository.mapper.CardMapper;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardMapper cMapper;

	@Override
	public void insertCard() {
		System.out.println("Service : insertCard");
	}

	@Override
	public void updateCard() {
		System.out.println("Service : updateCard");
		
	}

	@Override
	public void deleteCard() {
		System.out.println("Service : deleteCard");
		
	}

	@Override
	public void retrieveCardList() {
		System.out.println("Service : retrieveCardList");
		
	}

	@Override
	public void retrieveCard() {
		System.out.println("Service : retrieveCard");
		
	}

	@Override
	public void updateCardForm() {
		System.out.println("Service : updateCardForm");
		
	}

	@Override
	public void insertCardForm() {
		System.out.println("Service : insertCardForm");
		
	}
}
