package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.service.LikeEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like_events")
public class LikeEventController {

    private final LikeEventService likeEventService;

    public LikeEventController(LikeEventService likeEventService) {
        this.likeEventService = likeEventService;
    }

    /**
     * 특정 유저가 좋아요한 이벤트 ID 목록 조회 API
     * GET /like-events/user/{userId}
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Long>> getLikedEventsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(likeEventService.getLikedEventIdsByUserId(userId));
    }
}