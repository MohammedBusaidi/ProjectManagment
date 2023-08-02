package com.projectManagment.projectManagment.Controller;

import com.projectManagment.projectManagment.Models.APICustomResponse;
import com.projectManagment.projectManagment.Models.Board;
import com.projectManagment.projectManagment.Services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/boards")
public class BoardController extends GenericController {
    @Autowired
    BoardService boardService;

    @GetMapping
    public ResponseEntity<APICustomResponse> getAllBoards() {
        List<Board> boards = boardService.getAllBoards();
        return createResponse(
                Map.of("boards", boards),
                "List of all boards",
                OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<APICustomResponse> getBoardById(
            @PathVariable("id") Long boardId) {
        Board board = boardService.getBoardById(boardId);
        return createResponse(
                Map.of("board", board),
                "Board has been fetched successfully",
                OK);
    }

    @PostMapping
    public ResponseEntity<?> createBoard(
            @RequestBody Board board) {
        Long boardId = boardService.createBoard(board);
        return createResponse(
                Map.of("board_Id", boardId),
                "Board has been created successfully",
                CREATED);
    }

    @PostMapping("/activate/{id}")
    public ResponseEntity<APICustomResponse> activateBoard(
            @PathVariable("id") Long boardId) {
        Board board = boardService.activateBoard(boardId);
        return createResponse(
                Map.of("board", board),
                "Board with ID: " + boardId + " has been Re-Activated",
                CREATED);
    }
    @DeleteMapping("/deActivate/{id}")
    public ResponseEntity<APICustomResponse> deActivateBoard(
            @PathVariable("id") Long boardId) {
        boardService.deActivateBoard(boardId);
        return createResponse(
                null,
                "Board with ID: " + boardId + " has been De-Activated",
                OK);
    }
}
