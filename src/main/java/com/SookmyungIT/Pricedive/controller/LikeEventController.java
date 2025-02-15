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
     * 특정 유저가 좋아요한 이벤트 목록 조회
     * GET /like_events/user/{userId}
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Long>> getLikedEventsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(likeEventService.getLikedEventIdsByUserId(userId));
    }

    /**
     * 특정 유저가 특정 이벤트에 좋아요 추가
     * POST /like_events/user/{userId}/event/{eventId}
     */
    @PostMapping("/user/{userId}/event/{eventId}")
    public ResponseEntity<String> addLikeEvent(@PathVariable Long userId, @PathVariable Long eventId) {
        boolean isAdded = likeEventService.addLikeEvent(userId, eventId);
        return isAdded
                ? ResponseEntity.ok("좋아요가 추가되었습니다.")
                : ResponseEntity.badRequest().body("이미 좋아요한 이벤트입니다.");
    }

    /**
     * 특정 유저가 특정 이벤트에 좋아요 취소
     * DELETE /like_events/user/{userId}/event/{eventId}
     */
    @DeleteMapping("/user/{userId}/event/{eventId}")
    public ResponseEntity<String> removeLikeEvent(@PathVariable Long userId, @PathVariable Long eventId) {
        boolean isRemoved = likeEventService.removeLikeEvent(userId, eventId);
        return isRemoved
                ? ResponseEntity.ok("좋아요가 삭제되었습니다.")
                : ResponseEntity.badRequest().body("좋아요 상태가 아닙니다.");
    }
}