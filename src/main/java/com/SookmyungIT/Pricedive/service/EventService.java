package com.SookmyungIT.Pricedive.service;

import com.SookmyungIT.Pricedive.model.Event;
import com.SookmyungIT.Pricedive.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // 전체 이벤트 리스트 조회 메서드 추가
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}