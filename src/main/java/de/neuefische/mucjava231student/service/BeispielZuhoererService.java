package de.neuefische.mucjava231student.service;

import org.springframework.stereotype.Service;

@Service
public class BeispielZuhoererService implements NewsSubscriber {

    @Override
    public void handleNews(String news) {
        System.out.println("I bims der + " + this.getClass() + " und hier sind die News: " + news);
    }
}
