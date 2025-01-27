package com.SookmyungIT.Pricedive.service;

import com.SookmyungIT.Pricedive.dto.Event;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventService {

    private final Map<Long, Event> mockData = new HashMap<>();

    public EventService() {
        // 목데이터 초기화
        mockData.put(1L, new Event(1L, "Event 1", "Description of Event 1", "2025-01-27"));
        mockData.put(2L, new Event(2L, "Event 2", "Description of Event 2", "2025-02-01"));
        mockData.put(3L, new Event(3L, "Event 3", "Description of Event 3", "2025-03-15"));
    }

    public Event getEventById(Long id) {
        // 목데이터에서 이벤트를 조회
        if (!mockData.containsKey(id)) {
            throw new IllegalArgumentException("해당 ID의 이벤트를 찾을 수 없습니다: " + id);
        }
        return mockData.get(id);
    }
}