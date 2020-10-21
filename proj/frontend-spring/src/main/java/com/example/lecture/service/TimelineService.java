package com.example.lecture.service;

import com.example.lecture.entity.TimelinePost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TimelineService {
    public void register(TimelinePost timelinePost) throws Exception;

    @Query("select * from from timeline_post where userNo = :userNo")
    public List<TimelinePost> list(@Param("user_no") Long userNo) throws Exception;
}
