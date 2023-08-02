package com.projectManagment.projectManagment.Services;

import com.projectManagment.projectManagment.Models.Card;
import com.projectManagment.projectManagment.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
    public Long createCard(Card card) {
        LocalDateTime now = LocalDateTime.now();
        card.setCreatedDate(now);
        card.setActive(true);
        cardRepository.save(card);
        return card.getCardId();
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
    public Card getCardById(Long cardId) {
        return cardRepository.findById(cardId).get();
    }

    public Card updateCard(Long cardId, Card card) {
        LocalDateTime now = LocalDateTime.now();
        Card updateCard = cardRepository.findById(cardId).get();
        updateCard.setTitle(card.getTitle());
        updateCard.setSection(card.getSection());
        updateCard.setDescription(card.getDescription());
        updateCard.setBoard(card.getBoard());
        return cardRepository.save(card);
    }
}
