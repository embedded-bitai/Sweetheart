package com.example.lecture.service;

import com.example.lecture.entity.BitCamp;
import com.example.lecture.entity.DaumNews;
import com.example.lecture.entity.NaverNews;
import com.example.lecture.repository.BitCampRepository;
import com.example.lecture.repository.DaumNewsRepository;
import com.example.lecture.repository.NaverNewsRepository;
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
public class CrawlService {
    @Autowired
    DaumNewsRepository daumNewsRepository;
    @Autowired
    NaverNewsRepository naverNewsRepository;
    @Autowired
    BitCampRepository bitCampRepository;

    private Document document;

    public Document connectUrlDaum(String url) {
        log.info("connectUrlDaum(): " + url);

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
    public List<DaumNews> newsFindAllDaum() {
        log.info("newsFindAllDaum()");

        return daumNewsRepository.findAll();
    }
    public void mainCrawlerDaum() {
        log.info("mainCrawlerDaum()");

        document = connectUrlDaum("https://news.daum.net/");
        daumNewsRepository.deleteAll();

        // 양호
        daumNews(document.select("li>div.item_issue>a.link_thumb>img"));
    }
    public void daumNews(Elements elements) {
        log.info("daumNews(): elements - " + elements);
        DaumNews news = null;

        for (int i = 0; i < elements.size(); i++) {
            news = new DaumNews();

            news.setNewsNo(String.valueOf(daumNewsRepository.findAll().size() + 1));
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory("daumNews");
            news.setTitle(elements.get(i).text());
            news.setImage(elements.get(i).attr("src"));

            daumNewsRepository.save(news);
        }
    }

    public Document connectUrlNaver(String url) {
        log.info("connectUrlNaver(): " + url);

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
    public List<NaverNews> newsFindAllNaver() {
        log.info("newsFindAllNaver()");

        return naverNewsRepository.findAll();
    }
    public void mainCrawlerNaver() {
        log.info("mainCrawlerNaver()");

        // 네이버 뉴스 속보
        document = connectUrlNaver("https://news.naver.com/main/list.nhn?mode=LSD&mid=sec&sid1=001");
        naverNewsRepository.deleteAll();

        // 양호
        naverNews(document.select("ul.type06_headline>li>dl>dt>a>img"));
    }
    public void naverNews(Elements elements) {
        log.info("naverNews(): elements - " + elements);
        NaverNews news = null;

        for (int i = 0; i < elements.size(); i++) {
            news = new NaverNews();

            news.setNewsNo(String.valueOf(naverNewsRepository.findAll().size() + 1));
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory("naverNews");
            news.setTitle(elements.get(i).text());
            news.setImage(elements.get(i).attr("src"));

            naverNewsRepository.save(news);
        }
    }

    public Document connectUrlBitCamp(String url) {
        log.info("connectUrlBitCamp(): " + url);

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

    public List<BitCamp> findAllBitCamp() {
        log.info("newsFindAllBitCamp()");

        return bitCampRepository.findAll();
    }

    public void mainCrawlerBitCamp() {
        log.info("mainCrawlerBitCamp()");

        // 네이버 뉴스 속보
        document = connectUrlBitCamp("https://www.bitcamp.co.kr/");
        bitCampRepository.deleteAll();

        // 양호
        bitCamp(document.select("div.campaign-box>div.col-xs-4>div.thumbnail>img"));
//        bitCamp(document.select("div.col-xs-4>div.thumbnail>img"));
    }

    public void bitCamp(Elements elements) {
        log.info("bitCamp(): elements - " + elements);
        BitCamp news = null;

        for (int i = 0; i < elements.size(); i++) {
            news = new BitCamp();

            news.setAdsNo(String.valueOf(bitCampRepository.findAll().size() + 1));
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory("bitCamp");
            news.setTitle(elements.get(i).text());
            news.setImage(elements.get(i).attr("src"));

            bitCampRepository.save(news);
        }
    }
}