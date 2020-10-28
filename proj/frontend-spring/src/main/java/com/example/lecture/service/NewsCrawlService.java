package com.example.lecture.service;

import com.example.lecture.entity.DaumNews;
import com.example.lecture.repository.NewsRepository;

import lombok.extern.java.Log;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Log
public class NewsCrawlService {
    @Autowired
    NewsRepository newsRepository;

    private Document document;

    public Document connectUrl(String url) {
        log.info("connectUrl(): " + url);

        try {
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozila/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20100101 " +
                            "Firefox/10.0 AppleWebKit/537.36 (KHTML, like Gecko) " +
                            "Chrome/51.0.2704.103 Safari/537.36")
                    .execute();

            document = homepage.parse();
        } catch (Exception e) {
            System.out.println("Error in mainCrawler");
        }

        return document;
    }

    public List<DaumNews> newsFindAll() {
        log.info("newsFindAll()");

        return newsRepository.findAll();
    }

    public void mainCrawler() {
        log.info("mainCrawler()");

        document = connectUrl("https://news.daum.net/");
        newsRepository.deleteAll();

        // 양호
        daumNews(document.select("li>div.item_issue>a.link_thumb>img"));
    }

    public void daumNews(Elements elements) {
        log.info("daumNews(): elements - " + elements);
        DaumNews news = null;

        for (int i = 0; i < elements.size(); i++) {
            news = new DaumNews();

            news.setNewsNo(String.valueOf(newsRepository.findAll().size() + 1));
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory("daumNews");
            news.setTitle(elements.get(i).text());
            news.setImage(elements.get(i).attr("src"));

            newsRepository.save(news);
        }
    }
}