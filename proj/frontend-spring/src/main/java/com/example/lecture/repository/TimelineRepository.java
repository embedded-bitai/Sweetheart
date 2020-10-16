package com.example.lecture.repository;

import com.example.lecture.entity.TimelinePost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimelineRepository extends JpaRepository<TimelinePost, Long> {
    public List<TimelinePost> findByUserNo(Long userNo);
}
