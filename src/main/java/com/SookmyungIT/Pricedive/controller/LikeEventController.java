package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.service.LikeEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like-events")
public class LikeEventController {

    private final LikeEventService likeEventService;

    public LikeEventController(LikeEventService likeEventService) {
        this.likeEventService = likeEventService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Long>> getLikedEventIds(@PathVariable String userId) {
        List<Long> likedEventIds = likeEventService.getLikedEventIdsByUserId(userId);
        if (likedEventIds.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(likedEventIds);
    }
}