package com.ashu.cards.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.cards.models.Cards;

public interface CardsRepository extends JpaRepository<Cards, Long> {

}
