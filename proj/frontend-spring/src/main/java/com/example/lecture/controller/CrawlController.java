package com.example.lecture.controller;

import com.example.lecture.entity.BitCamp;
import com.example.lecture.entity.DaumNews;
import com.example.lecture.entity.NaverNews;
import com.example.lecture.service.CrawlService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CrawlController {
    @Autowired
    CrawlService newsCrawler;

    @GetMapping("/crawlDaumNews")
    public List<DaumNews> crawlingDaumNews() {
        log.info("crawlingDaumNews()");

        newsCrawler.mainCrawlerDaum();
        return newsCrawler.newsFindAllDaum();
    }

    @GetMapping("/crawlNaverNews")
    public List<NaverNews> crawlingNaverNews() {
        log.info("crawlingNaverNews()");

        newsCrawler.mainCrawlerNaver();
        return newsCrawler.newsFindAllNaver();
    }

    @GetMapping("/crawlBitCamp")
    public List<BitCamp> crawlingBitCamp() {
        log.info("crawlingBitCamp()");

        newsCrawler.mainCrawlerBitCamp();
        return newsCrawler.findAllBitCamp();
    }
}