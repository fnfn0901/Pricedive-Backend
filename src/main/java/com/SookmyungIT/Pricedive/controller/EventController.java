package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.model.Event;
import com.SookmyungIT.Pricedive.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<Event> getEvents(@RequestParam(required = false) String category,
                                 @RequestParam(required = false) String keyword,
                                 @RequestParam(required = false) Long userId) {
        return eventService.getEvents(category, keyword, userId);
    }
}