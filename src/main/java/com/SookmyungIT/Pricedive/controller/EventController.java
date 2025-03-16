package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.dto.APIResponse;
import com.SookmyungIT.Pricedive.dto.EventDTO;
import com.SookmyungIT.Pricedive.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<EventDTO>> getEventById(@PathVariable Long id) {
        EventDTO event = eventService.getEventById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 이벤트를 찾을 수 없습니다."));
        return ResponseEntity.ok(APIResponse.success(event, "이벤트 조회 성공"));
    }

    /**
     * ✅ 카테고리 및 event_item 검색을 이용한 이벤트 필터링
     */
    @GetMapping
    public ResponseEntity<APIResponse<List<EventDTO>>> getEvents(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String search
    ) {
        System.out.println("✅ [Controller] 검색어: " + search + ", 카테고리: " + category);
        List<EventDTO> events = eventService.getEvents(category, search);
        return ResponseEntity.ok(APIResponse.success(events, "이벤트 목록 조회 성공"));
    }
}