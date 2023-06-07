package de.neuefische.mucjava231student.service;

public interface NewsPublisher {

    void addSubscriber(NewsSubscriber subscriber);
    void removeSubscriber(NewsSubscriber subscriber);
    void notifySubscribers(String news);
}
