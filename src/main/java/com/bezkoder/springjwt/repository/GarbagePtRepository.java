package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.GarbagePt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarbagePtRepository extends JpaRepository<GarbagePt,Integer> {
    GarbagePt findGarbagePtById(Integer id);
}
