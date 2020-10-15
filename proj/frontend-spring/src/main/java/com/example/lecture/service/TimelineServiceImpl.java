package com.example.lecture.service;

import com.example.lecture.entity.TimelinePost;
import com.example.lecture.repository.TimelineRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class TimelineServiceImpl implements TimelineService{

    @Autowired
    private TimelineRepository repository;

    @Override
    public void register(TimelinePost timeline) throws Exception {
        log.info("register: " + timeline);

        TimelinePost timelinePost = new TimelinePost();
        timelinePost.setUserNo(timeline.getUserNo());
        timelinePost.setImage(timeline.getImage());
        timelinePost.setContent(timeline.getContent());

        repository.save(timelinePost);

        timelinePost.setPostNo(timeline.getPostNo());
    }

    @Override
    public List<TimelinePost> list(Long userNo) throws Exception {
        return repository.findByUserNo(userNo);
    }
}
