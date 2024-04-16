package com.ashu.cards.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.cards.models.Cards;

public interface CardsRepository extends JpaRepository<Cards, Long> {
	public Optional<Cards> findByMobileNumber(String mobileNumber);
	
}
