package com.projectManagment.projectManagment.Services;

import com.projectManagment.projectManagment.Models.Board;
import com.projectManagment.projectManagment.Models.Card;
import com.projectManagment.projectManagment.Repository.BoardRepository;
import com.projectManagment.projectManagment.Repository.CardRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BoardRepository boardRepository;

    public Long createCard(Long boardId,Card card) {
        LocalDateTime now = LocalDateTime.now();
        Board board = boardRepository.findById(boardId).get();
        Card cardInstance = new Card();
        cardInstance.setCreatedDate(now);
        cardInstance.setActive(true);
        cardInstance.setBoard(board);
        cardInstance.setCardId(card.getCardId());
        cardInstance.setTitle(card.getTitle());
        cardInstance.setDescription(card.getDescription());
        cardInstance.setSection(card.getSection());
        cardRepository.save(cardInstance);
        return cardInstance.getCardId();
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

    public Card activateCard(Long cardId) {
        Card card = cardRepository.findById(cardId).get();
        card.setActive(true);
        cardRepository.save(card);
        return card;
    }

    public void deActivateCard(Long boardId) {
        Card card = cardRepository.findById(boardId).get();
        card.setActive(false);
        cardRepository.save(card);
    }

    public void deleteCard(Long cardId) {
        Card card = cardRepository
                .findById(cardId).get();
        cardRepository.delete(card);
    }
}
