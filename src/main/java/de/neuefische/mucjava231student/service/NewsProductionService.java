package de.neuefische.mucjava231student.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsProductionService implements NewsPublisher {

    private final List<NewsSubscriber> subscribers = new ArrayList<>();

    @Override
    public void addSubscriber(NewsSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(NewsSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String news) {
        for (NewsSubscriber subscriber : subscribers) {
            subscriber.handleNews(news);
        }
    }
}
