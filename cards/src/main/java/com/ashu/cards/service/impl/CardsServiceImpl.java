package com.ashu.cards.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ashu.cards.constants.CardsConstant;
import com.ashu.cards.dto.CardsDto;
import com.ashu.cards.exception.ResourceNotFoundException;
import com.ashu.cards.mapper.CardsMapper;
import com.ashu.cards.models.Cards;
import com.ashu.cards.repository.CardsRepository;
import com.ashu.cards.service.ICardsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

	private CardsRepository cardsRepository;

	@Override
	public void createCard(String mobileNumber) {
		Cards card = new Cards();
		card.setAmountUsed(0);
		card.setCardNumber(UUID.randomUUID().toString());
		card.setAvailableAmount(0);
		card.setCardType(CardsConstant.SAVINGS);
		card.setMobileNumber(mobileNumber);
		card.setTotalLimit(CardsConstant.NEW_CARD_LIMIT);
		cardsRepository.save(card);
	}

	@Override
	public CardsDto fetchCard(String mobileNumber) {
		Cards card = cardsRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
		return CardsMapper.mapToCardsDto(card, new CardsDto());
	}

	@Override
	public boolean updateCard(CardsDto cardsDto) {
		Cards card = cardsRepository.findByMobileNumber(cardsDto.getMobileNumber())
				.orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", cardsDto.getMobileNumber()));

		CardsMapper.mapToCards(cardsDto, card);
		cardsRepository.save(card);
		return true;
	}

	@Override
	public boolean deleteCard(String mobileNumber) {
		Cards card = cardsRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
		cardsRepository.delete(card);
		return true;
	}

}
