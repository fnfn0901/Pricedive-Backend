package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.model.Event;
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
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 이벤트를 찾을 수 없습니다."));
        return ResponseEntity.ok(event);
    }
}