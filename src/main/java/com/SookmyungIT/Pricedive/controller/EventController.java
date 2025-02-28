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

    @GetMapping
    public ResponseEntity<APIResponse<List<EventDTO>>> getAllEvents() {
        List<EventDTO> events = eventService.getAllEvents();
        return ResponseEntity.ok(APIResponse.success(events, "전체 이벤트 조회 성공"));
    }
}