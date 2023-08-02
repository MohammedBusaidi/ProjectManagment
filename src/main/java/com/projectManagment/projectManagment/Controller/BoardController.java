package com.projectManagment.projectManagment.Controller;

import com.projectManagment.projectManagment.Services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/boards")
public class BoardController {
    @Autowired
    BoardService boardService;

}
