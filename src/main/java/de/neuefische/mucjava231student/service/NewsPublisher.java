package de.neuefische.mucjava231student.service;

// Sendet Nachrichten an Abonnenten
public interface NewsPublisher {

    void addSubscriber(NewsSubscriber subscriber);
    void removeSubscriber(NewsSubscriber subscriber);
    void notifySubscribers(String news);
}
