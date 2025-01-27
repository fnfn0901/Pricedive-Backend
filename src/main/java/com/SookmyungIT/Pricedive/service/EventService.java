package com.SookmyungIT.Pricedive.service;

import com.SookmyungIT.Pricedive.dto.Event;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventService {

    private final Map<Long, Event> eventData;

    public EventService() {
        this.eventData = initializeEventData();
    }

    public Event getEventById(Long id) {
        if (!eventData.containsKey(id)) {
            throw new IllegalArgumentException("해당 ID의 이벤트를 찾을 수 없습니다: " + id);
        }
        return eventData.get(id);
    }

    private Map<Long, Event> initializeEventData() {
        Map<Long, Event> data = new HashMap<>();
        data.put(1L, new Event(1L, "Event 1", "Description of Event 1", "2025-01-27"));
        data.put(2L, new Event(2L, "Event 2", "Description of Event 2", "2025-02-01"));
        data.put(3L, new Event(3L, "Event 3", "Description of Event 3", "2025-03-15"));
        return data;
    }
}