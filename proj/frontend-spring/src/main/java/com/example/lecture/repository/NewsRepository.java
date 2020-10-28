package com.example.lecture.repository;

import com.example.lecture.entity.DaumNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<DaumNews, Long> {
    public DaumNews findByNewsNo(String newsNo);
}
