package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.GarbagePt;
import com.bezkoder.springjwt.models.WasteLevel;
import com.bezkoder.springjwt.security.services.GarbageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowedHeaders = "*",allowCredentials = "true")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GarbageController {
  private final GarbageService garbageService;

  @GetMapping("/all")
  public List<GarbagePt> allAccess() {
    return garbageService.getAllGarbagePoint();
  }

  @GetMapping("/{id}")
  public GarbagePt getGarbagePtById(@PathVariable Integer id) {
    return garbageService.getGarbagePtById(id);
  }
  @GetMapping("/api/garbage-points")
  public List<GarbagePt> searchGarbagePoints(@RequestParam("search") String query) {
    return garbageService.searchGarbagePoints(query);
  }
  @PostMapping("/add")
  public GarbagePt addGarbagePoint(@RequestBody GarbagePt garbagePt) {
    return garbageService.addGarbagePoint(garbagePt);
  }
  @DeleteMapping("/delete/{id}")
  public void deleteGarbage(@PathVariable Integer id) {
    garbageService.deleteGarbage(id);
  }

  @PutMapping("/update/{id}")
  public GarbagePt updateGarbagePoint(@PathVariable Integer id,@RequestBody GarbagePt garbagePt) {
    return garbageService.updateGarbagePoint(id,garbagePt);

  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
}
