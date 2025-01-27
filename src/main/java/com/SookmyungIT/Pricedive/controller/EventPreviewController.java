package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.dto.EventPreview;
import com.SookmyungIT.Pricedive.service.EventPreviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event-previews")
public class EventPreviewController {

    private final EventPreviewService eventPreviewService;

    public EventPreviewController(EventPreviewService eventPreviewService) {
        this.eventPreviewService = eventPreviewService;
    }

    @GetMapping
    public ResponseEntity<List<EventPreview>> getEventPreviews(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Boolean isLiked
    ) {
        List<EventPreview> previews = eventPreviewService.getEventPreviews(category, keyword, isLiked);

        if (previews.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(previews);
    }
}