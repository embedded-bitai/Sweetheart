package com.example.lecture.service;

import com.example.lecture.entity.TimelinePost;

import java.util.List;

public interface TimelineService {
    public void register(TimelinePost timelinePost) throws Exception;
    public List<TimelinePost> list(Long userNo) throws Exception;
}
