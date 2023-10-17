package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.models.GarbagePt;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.GarbagePtRepository;
import com.bezkoder.springjwt.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GarbageService {
    private final GarbagePtRepository garbagePtRepository;
    private final GarbageAlert garbageAlert;
    private final UserRepository userRepository;

    public List<GarbagePt> getAllGarbagePoint() {
        return garbagePtRepository.findAll();
    }

    public GarbagePt addGarbagePoint(GarbagePt garbagePt) {
        garbagePt.setCreatedOn(LocalDate.now());
        garbagePt.setWasteLevels("0");
        return garbagePtRepository.save(garbagePt);
    }

    public void deleteGarbage(Integer id) {
        garbagePtRepository.deleteById(id);
    }

    public GarbagePt updateGarbagePoint(Integer id, GarbagePt garbagePt) {
        GarbagePt garbagePt1 =  garbagePtRepository.findGarbagePtById(id);
       garbagePt1.setWasteLevels(garbagePt.getWasteLevels());
        return garbagePtRepository.save(garbagePt1);
    }

    public GarbagePt getGarbagePtById(Integer id) {
        return  garbagePtRepository.findGarbagePtById(id);
    }


    public List<GarbagePt> searchGarbagePoints(String name) {
        return garbagePtRepository.findGarbagePtByNameContaining(name);
    }

    public void addWasteLevelToGarbagePoint(Integer id, String wasteLevel) {
        GarbagePt garbagePt = garbagePtRepository.findGarbagePtById(id);
        if (garbagePt!=null){
            garbagePt.setWasteLevels(wasteLevel);
            garbagePtRepository.save(garbagePt);
            checkAlert(garbagePt);
        }
        else {
            throw new RuntimeException("No waste level updated !!");
        }

    }

    public void checkAlert(GarbagePt garbagePt){
        int wasteLevel = Integer.parseInt(garbagePt.getWasteLevels());
        if(wasteLevel >= 80){
            garbageAlert.sendsAlert(garbagePt);
        }
    }

    public ResponseEntity<?> assignPersonel(Integer id, String username) {
        Optional<User> userExist = userRepository.findByUsername(username);
        if(!userExist.isPresent()){
            return ResponseEntity.status(400).body("User "+ username + "does not exist");
        }
        GarbagePt garbagePt = garbagePtRepository.findGarbagePtById(id);
        garbagePt.setUser(userExist.get());
        
        return ResponseEntity.status(200).body(username + "assign to "+ garbagePt.getName() + "successfully" );
    }
}
