package com.projectManagment.projectManagment.Services;

import com.projectManagment.projectManagment.Models.Card;
import com.projectManagment.projectManagment.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}
