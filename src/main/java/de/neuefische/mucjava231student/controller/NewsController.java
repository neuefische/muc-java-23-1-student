package de.neuefische.mucjava231student.controller;

import de.neuefische.mucjava231student.service.NewsProductionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsProductionService newsService;

    public NewsController(NewsProductionService newsService) {
        this.newsService = newsService;
    }

    // create a new endpoint that allows to send news
    // the news should be sent to all subscribers
    // the news should be sent as a request body
    // the news should be sent as a POST request
    @PostMapping
    public void sendNews(@RequestBody String news) {
        newsService.notifySubscribers(news);
    }

}
