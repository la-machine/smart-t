package com.bezkoder.springjwt.controllers;
import com.bezkoder.springjwt.models.GarbagePt;
import com.bezkoder.springjwt.models.WasteLevel;
import com.bezkoder.springjwt.security.services.GarbageService;
import com.bezkoder.springjwt.security.services.WasteLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class WasteLevelController {

        private final WasteLevelService boardService;

        @GetMapping("/all")
        @PreAuthorize("hasRole('ADMIN')")
        public List<WasteLevel> allAccess () {
            return boardService.getAllBoard();
        }



        @PostMapping("/add")
        @PreAuthorize(" hasRole('ADMIN')")
        public WasteLevel addBoard (@RequestBody WasteLevel board){

        return boardService.addBoard(board);
    }
        @DeleteMapping("/delete/{id}")
        @PreAuthorize("hasRole('ADMIN')")
        public void deleteBoard (@PathVariable Integer id){
        boardService.deleteBoard(id);
    }

        @PutMapping("/update/{id}")
        @PreAuthorize("hasRole('ADMIN')")
        public WasteLevel updateBoard (@PathVariable Integer id, @RequestBody WasteLevel board){
        return boardService.updateBoard(id, board);

    }

        @GetMapping("/admin")
        @PreAuthorize("hasRole('ADMIN')")
        public String adminAccess () {
        return "Admin Board.";

    }
    @PostMapping("/garbage-point/waste-level/{id}")
    public GarbagePt addWasteLevelToGarbagePoint(@PathVariable Integer id, @RequestBody WasteLevel wasteLevel){
            return boardService.addWasteLevelToGarbagePoint(id,wasteLevel);
    }
}
