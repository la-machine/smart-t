package com.bezkoder.springjwt.security.services;
import com.bezkoder.springjwt.models.GarbagePt;
import com.bezkoder.springjwt.models.WasteLevel;
import com.bezkoder.springjwt.repository.BoardRepository;
import com.bezkoder.springjwt.repository.GarbagePtRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WasteLevelService {
    private final BoardRepository boardRepository;
    private final GarbagePtRepository garbagePtRepository;

    public List<WasteLevel> getAllBoard() {
        return boardRepository.findAll();
    }

    public WasteLevel addBoard(WasteLevel board) {
        return boardRepository.save(board);
    }

    public void deleteBoard(Integer id) {
        boardRepository.deleteById(id);
    }

    public WasteLevel updateBoard(Integer id, WasteLevel board) {
        WasteLevel board1 =  boardRepository.findBoardById(id);
        board1.setWasteLevel(board.getWasteLevel());
        return boardRepository.save(board1);
    }

    public GarbagePt addWasteLevelToGarbagePoint(Integer garbagePtId, WasteLevel wasteLevel) {
        // Retrieve the existing GarbagePoint
        GarbagePt garbagePt = garbagePtRepository.findById(garbagePtId).orElse(null);

        if (garbagePt != null) {
            // Save the new WasteLevel to the database
            WasteLevel savedWasteLevel = boardRepository.save(wasteLevel);

            // Retrieve the existing list of WasteLevel from the GarbagePoint
            List<WasteLevel> existingWasteLevels = garbagePt.getWasteLevels();

            if (existingWasteLevels == null) {
                existingWasteLevels = new ArrayList<>();
            }
            existingWasteLevels.add(savedWasteLevel);
            garbagePt.setWasteLevels(existingWasteLevels);
            return garbagePtRepository.save(garbagePt);
        }

        return null;
    }

}


