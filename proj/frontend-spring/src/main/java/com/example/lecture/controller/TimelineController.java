package com.example.lecture.controller;

import com.example.lecture.entity.TimelinePost;
import com.example.lecture.service.TimelineService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/timeline")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class TimelineController {

    @Autowired
    TimelineService timelineService;

    @PostMapping("/register")
    public ResponseEntity<TimelinePost> register(@Validated @RequestBody TimelinePost timelinePost) throws Exception {
        log.info("register() - " + timelinePost);

        timelineService.register(timelinePost);

        return new ResponseEntity<>(timelinePost, HttpStatus.OK);
    }

    @GetMapping("/list/{userNo}")
    public ResponseEntity<List<TimelinePost>> list(@PathVariable("userNo") Long userNo) throws Exception {
        log.info("list() - userNo: " + userNo);
        List<TimelinePost> timelinePosts = timelineService.list(userNo);

        return new ResponseEntity<>(timelinePosts, HttpStatus.OK);
    }

    @GetMapping("/list/all")
    public ResponseEntity<List<TimelinePost>> listAll() throws Exception {
        log.info("listAll()" );
        List<TimelinePost> timelinePosts = timelineService.listAll();

        return new ResponseEntity<>(timelinePosts, HttpStatus.OK);
    }

}
