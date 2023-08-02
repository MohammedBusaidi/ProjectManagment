package com.projectManagment.projectManagment.Services;

import com.projectManagment.projectManagment.Models.Board;
import com.projectManagment.projectManagment.Repository.BoardRepository;
import com.projectManagment.projectManagment.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    CardRepository cardRepository;

}
