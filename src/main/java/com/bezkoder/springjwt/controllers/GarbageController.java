package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.GarbagePt;
import com.bezkoder.springjwt.security.services.GarbageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowedHeaders = "*",allowCredentials = "true")
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
  @GetMapping("/garbage-points/search/{name}")
  public List<GarbagePt> searchGarbagePoints( @PathVariable String name) {
    return garbageService.searchGarbagePoints(name);
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
    System.out.println(garbagePt);
    return garbageService.updateGarbagePoint(id,garbagePt);
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }

  @PutMapping(value = "/wasteLevel/{id}")
  public void addWasteLevelToGarbagePoint(@PathVariable Integer id,@RequestBody String wasteLevel){
    garbageService.addWasteLevelToGarbagePoint(id,wasteLevel);
  }
}
