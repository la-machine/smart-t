package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.models.GarbagePt;
import com.bezkoder.springjwt.repository.GarbagePtRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GarbageService {
    private final GarbagePtRepository garbagePtRepository;

    public List<GarbagePt> getAllGarbagePoint() {
        return garbagePtRepository.findAll();
    }

    public GarbagePt addGarbagePoint(GarbagePt garbagePt) {
        return garbagePtRepository.save(garbagePt);
    }

    public void deleteGarbage(Integer id) {
        garbagePtRepository.deleteById(id);
    }

    public GarbagePt updateGarbagePoint(Integer id, GarbagePt garbagePt) {
        GarbagePt garbagePt1 =  garbagePtRepository.findGarbagePtById(id);
        garbagePt1.setName(garbagePt.getName());
        garbagePt1.setTown(garbagePt.getTown());
        garbagePt1.setLon(garbagePt.getLon());
        garbagePt1.setLat(garbagePt.getLat());
        garbagePt1.setCreatedOn(garbagePt.getCreatedOn());
        return garbagePtRepository.save(garbagePt1);
    }

    public GarbagePt getGarbagePtById(Integer id) {
        return  garbagePtRepository.findGarbagePtById(id);
    }

    public List<GarbagePt> searchGarbagePoints(String query) {
        return garbagePtRepository.findByNameIn(query);
    }
}
