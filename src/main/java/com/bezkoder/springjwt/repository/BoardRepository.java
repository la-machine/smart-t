package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.WasteLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<WasteLevel,Integer> {
    WasteLevel findBoardById(Integer id);
}
