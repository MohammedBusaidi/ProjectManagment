package com.projectManagment.projectManagment.Controller;

import com.projectManagment.projectManagment.Models.APICustomResponse;
import com.projectManagment.projectManagment.Models.Board;
import com.projectManagment.projectManagment.Models.Card;
import com.projectManagment.projectManagment.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/cards")
public class CardController extends GenericController {
    @Autowired
    CardService cardService;

    @GetMapping
    public ResponseEntity<APICustomResponse> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return createResponse(
                Map.of("cards", cards),
                "List of all cards",
                OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<APICustomResponse> getCardById(
            @PathVariable("id") Long cardId) {
        Card card = cardService.getCardById(cardId);
        return createResponse(
                Map.of("board", card),
                "Board has been fetched successfully",
                OK);
    }

    @PostMapping
    public ResponseEntity<?> createCard(
            @RequestBody Card card) {
        Long cardId = cardService.createCard(card);
        return createResponse(
                Map.of("card_Id", cardId),
                "Card has been created successfully",
                CREATED);
    }

    @PutMapping("{cardId}/assign/{boardId}")
    public ResponseEntity<APICustomResponse> assignCard(
            @PathVariable Long cardId,
            @PathVariable Long boardId
    ) {
        cardService.assignCards(cardId, boardId);
        return createResponse(
                Map.of("card_Id", cardId),
                "Card has been assigned successfully",
                OK);
    }
    @PutMapping("{cardId}/update")
    public ResponseEntity<APICustomResponse> updateCard(
            @PathVariable("id") Long cardId,
            @RequestBody Card card
    ) {
        cardService.updateCard(cardId, card);
        return createResponse(
                Map.of("card_Id", cardId),
                "Card has been updated successfully",
                OK);
    }

    @PostMapping("/activate/{id}")
    public ResponseEntity<APICustomResponse> activateCard(
            @PathVariable("id") Long cardId) {
        Card card = cardService.activateCard(cardId);
        return createResponse(
                Map.of("board", card),
                "Card with ID: " + cardId + " has been Re-Activated",
                CREATED);
    }

    @DeleteMapping("/deActivate/{id}")
    public ResponseEntity<APICustomResponse> deActivateCard(
            @PathVariable("id") Long cardId) {
        cardService.deActivateCard(cardId);
        return createResponse(
                null,
                "Card with ID: " + cardId + " has been De-Activated",
                OK);
    }
}


