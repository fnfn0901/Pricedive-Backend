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
                .map(this::convertToDTO);
    }

    /**
     * ✅ 카테고리 및 검색어 필터링
     */
    public List<EventDTO> getEvents(String category, String search) {
        List<Event> events;

        if (category != null && search != null) {
            events = eventRepository.findByCategoryAndTitleContainingIgnoreCase(category, search);
        } else if (category != null) {
            events = eventRepository.findByCategory(category);
        } else if (search != null) {
            events = eventRepository.findByTitleContainingIgnoreCase(search);
        } else {
            events = eventRepository.findAll();
        }

        return events.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private EventDTO convertToDTO(Event event) {
        return new EventDTO(
                event.getId(),
                event.getCategory(),
                event.getEventNums(),
                event.getEventItem(),
                event.getPreviewImg(),
                event.getVideoId(),
                event.getDateEnd(),
                event.getTitle(),
                event.isLiked()
        );
    }
}