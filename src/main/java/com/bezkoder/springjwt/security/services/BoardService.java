package com.bezkoder.springjwt.security.services;
import com.bezkoder.springjwt.models.Board;
import com.bezkoder.springjwt.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    public Board addBoard(Board board) {
        return boardRepository.save(board);
    }

    public void deleteBoard(Integer id) {
        boardRepository.deleteById(id);
    }

    public Board updateBoard(Integer id, Board board) {
        Board board1 =  boardRepository.findBoardById(id);
        board1.setWasteLevel(board.getWasteLevel());
        return boardRepository.save(board1);
    }
}


