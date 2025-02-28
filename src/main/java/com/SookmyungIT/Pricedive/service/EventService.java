package com.SookmyungIT.Pricedive.service;

import com.SookmyungIT.Pricedive.dto.EventDTO;
import com.SookmyungIT.Pricedive.model.Event;
import com.SookmyungIT.Pricedive.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Optional<EventDTO> getEventById(Long id) {
        return eventRepository.findById(id)
                .map(event -> new EventDTO(
                        event.getId(),
                        event.getCategory(),
                        event.getEventNums(),
                        event.getEventItem(),
                        event.getPreviewImg(),
                        event.getVideoId(),
                        event.getDateEnd(),
                        event.getTitle(),
                        event.isLiked()
                ));
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(event -> new EventDTO(
                        event.getId(),
                        event.getCategory(),
                        event.getEventNums(),
                        event.getEventItem(),
                        event.getPreviewImg(),
                        event.getVideoId(),
                        event.getDateEnd(),
                        event.getTitle(),
                        event.isLiked()
                ))
                .collect(Collectors.toList());
    }
}