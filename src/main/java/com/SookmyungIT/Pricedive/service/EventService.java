package com.SookmyungIT.Pricedive.service;

import com.SookmyungIT.Pricedive.dto.EventDTO;
import com.SookmyungIT.Pricedive.model.Event;
import com.SookmyungIT.Pricedive.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
     * ✅ 카테고리 및 event_item 검색을 이용한 이벤트 필터링
     */
    public List<EventDTO> getEvents(String category, String search) {
        System.out.println("✅ [Service] 검색어: " + search + ", 카테고리: " + category);

        List<Event> events;
        if (category != null && search != null) {
            events = eventRepository.searchByCategoryAndEventItemOrChannelId(category, search);
        } else if (category != null) {
            events = eventRepository.findByCategory(category);
        } else if (search != null) {
            events = eventRepository.searchByEventItemOrChannelId(search);
        } else {
            events = eventRepository.findAll();
        }

        // dateEnd 기준으로 내림차순 정렬
        events.sort((e1, e2) -> e2.getDateEnd().compareTo(e1.getDateEnd()));

        return events.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * ✅ Event -> EventDTO 변환 + dateEnd null 처리
     */
    private EventDTO convertToDTO(Event event) {
        // 기본값 설정
        LocalDateTime defaultDateEnd = LocalDateTime.of(2000, 1, 1, 0, 0);

        return new EventDTO(
                event.getEventId(),
                event.getCategory(),
                event.getEventNums(),
                event.getEventItem(),
                event.getPreviewImg(),
                event.getVideoId(),
                event.getChannelImg(),
                event.getChannelId(),
                event.getDateEnd() != null ? event.getDateEnd() : defaultDateEnd
        );
    }
}