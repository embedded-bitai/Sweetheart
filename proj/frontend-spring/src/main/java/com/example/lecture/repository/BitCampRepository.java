package com.example.lecture.repository;

import com.example.lecture.entity.BitCamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BitCampRepository extends JpaRepository<BitCamp, Long> {
    public BitCamp findByAdsNo(String adsNo);
}