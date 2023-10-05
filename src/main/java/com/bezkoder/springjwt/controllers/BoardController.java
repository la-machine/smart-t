package com.bezkoder.springjwt.controllers;
import com.bezkoder.springjwt.models.Board;
import com.bezkoder.springjwt.models.GarbagePt;
import com.bezkoder.springjwt.security.services.BoardService;
import com.bezkoder.springjwt.security.services.GarbageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

        private final BoardService boardService;

        @GetMapping("/all")
        @PreAuthorize("hasRole('ADMIN')")
        public List<Board> allAccess () {
            return boardService.getAllBoard();
        }



        @PostMapping("/add")
        @PreAuthorize(" hasRole('ADMIN')")
        public Board addBoard (@RequestBody Board board){
        return boardService.addBoard(board);
    }
        @DeleteMapping("/delete/{id}")
        @PreAuthorize("hasRole('ADMIN')")
        public void deleteBoard (@PathVariable Integer id){
        boardService.deleteBoard(id);
    }

        @PutMapping("/update/{id}")
        @PreAuthorize("hasRole('ADMIN')")
        public Board updateBoard (@PathVariable Integer id, @RequestBody Board board){
        return boardService.updateBoard(id, board);

    }

        @GetMapping("/admin")
        @PreAuthorize("hasRole('ADMIN')")
        public String adminAccess () {
        return "Admin Board.";

    }
}
