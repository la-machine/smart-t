package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {
    Board findBoardById(Integer id);
}
