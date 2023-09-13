package com.projectManagment.projectManagment.Controller;

import com.projectManagment.projectManagment.Models.APICustomResponse;
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
@CrossOrigin ("*")
@RequestMapping("api/boards/{boardId}/cards")
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

    @GetMapping("{cardId}")
    public ResponseEntity<APICustomResponse> getCardById(
            @PathVariable("cardId") Long cardId) {
        Card card = cardService.getCardById(cardId);
        return createResponse(
                Map.of("Card", card),
                "Card has been fetched successfully",
                OK);
    }

    @PostMapping
    public ResponseEntity<?> createCard(
            @PathVariable("boardId") Long boardId,
            @RequestBody Card card
            ) {
        Long createdCard = cardService.createCard(boardId, card);

        return createResponse(
                Map.of("card_Id", createdCard),
                "Card has been created successfully",
                CREATED);
    }

    @PutMapping("{cardId}")
    public ResponseEntity<APICustomResponse> updateCard(
            @PathVariable("cardId") Long cardId,
            @RequestBody Card card
    ) {
        cardService.updateCard(cardId, card);
        return createResponse(
                Map.of("card_Id", cardId),
                "Card has been updated successfully",
                OK);
    }

    @PostMapping("activate/{cardId}")
    public ResponseEntity<APICustomResponse> activateCard(
            @PathVariable("cardId") Long cardId) {
        Card card = cardService.activateCard(cardId);
        return createResponse(
                Map.of("board", card),
                "Card with ID: " + cardId + " has been Re-Activated",
                CREATED);
    }

    @DeleteMapping("deActivate/{cardId}")
    public ResponseEntity<APICustomResponse> deActivateCard(
            @PathVariable("cardId") Long cardId) {
        cardService.deActivateCard(cardId);
        return createResponse(
                null,
                "Card with ID: " + cardId + " has been De-Activated",
                OK);
    }

    @DeleteMapping("{cardId}")
    public ResponseEntity<APICustomResponse> deleteCard(
            @PathVariable("cardId") Long cardId) {
        cardService.deleteCard(cardId);
        return createResponse(
                null,
                "Card with ID: " + cardId + " has been Deleted",
                OK);
    }
}


