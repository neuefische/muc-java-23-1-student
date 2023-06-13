package de.neuefische.mucjava231student.service;

// Observer = Subscriber = Listener = Empfänger
public interface NewsSubscriber {

    void handleNews(String news);
}
