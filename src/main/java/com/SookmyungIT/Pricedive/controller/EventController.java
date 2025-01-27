package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.dto.APIResponse;
import com.SookmyungIT.Pricedive.dto.Event;
import com.SookmyungIT.Pricedive.service.EventService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public APIResponse<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return new APIResponse<>(true, "이벤트를 성공적으로 가져왔습니다.", event);
    }
}