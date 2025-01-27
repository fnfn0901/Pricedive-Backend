package com.SookmyungIT.Pricedive.service;

import com.SookmyungIT.Pricedive.model.Event;
import com.SookmyungIT.Pricedive.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents(String category, String keyword, Long userId) {
        return eventRepository.findByFilters(category, keyword, userId);
    }
}