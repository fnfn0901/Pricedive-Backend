package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.dto.EventFilterRequest;
import com.SookmyungIT.Pricedive.dto.EventResponse;
import com.SookmyungIT.Pricedive.model.Event;
import com.SookmyungIT.Pricedive.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/filter")
    public List<EventResponse> filterEvents(@RequestBody EventFilterRequest filterRequest) {
        List<Event> events = eventService.getEvents(filterRequest.getCategory(),
                filterRequest.getKeyword(), filterRequest.getUserId());

        return events.stream()
                .map(event -> {
                    EventResponse response = new EventResponse();
                    response.setId(event.getId());
                    response.setTitle(event.getTitle());
                    response.setDescription(event.getDescription());
                    response.setChannelId(event.getChannelId());
                    response.setChannelImg(event.getChannelImg());
                    response.setTags(event.getTags());
                    response.setUrlLink(event.getUrlLink());
                    response.setDateStart(event.getDateStart());
                    response.setDateEnd(event.getDateEnd());
                    response.setSummarizedDescription(event.getSummarizedDescription());
                    return response;
                })
                .collect(Collectors.toList());
    }
}