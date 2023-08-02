package com.projectManagment.projectManagment.Services;

import com.projectManagment.projectManagment.Models.Board;
import com.projectManagment.projectManagment.Repository.BoardRepository;
import com.projectManagment.projectManagment.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    CardRepository cardRepository;

    public Long createBoard(Board board) {
        LocalDateTime now = LocalDateTime.now();
        board.setCreatedDate(now);
        board.setActive(true);
        boardRepository.save(board);
        return board.getBoardId();
    }
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }
}
