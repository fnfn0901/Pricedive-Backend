package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.model.Event;
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
     * 특정 유저가 좋아요한 전체 또는 진행 중인 이벤트 목록 조회
     * GET /like_events/user/{userId}?ongoing=true
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Event>> getLikedEventsByUserId(
            @PathVariable Long userId,
            @RequestParam(value = "ongoing", required = false, defaultValue = "false") boolean ongoing) {

        List<Event> likedEvents = likeEventService.getLikedEventsByUserId(userId, ongoing);
        return ResponseEntity.ok(likedEvents);
    }

    /**
     * 특정 유저가 특정 이벤트에 좋아요 추가
     * POST /like_events/user/{userId}/event/{eventId}
     */
    @PostMapping("/user/{userId}/event/{eventId}")
    public ResponseEntity<String> addLikeEvent(@PathVariable Long userId, @PathVariable Long eventId) {
        try {
            boolean isAdded = likeEventService.addLikeEvent(userId, eventId);
            return isAdded
                    ? ResponseEntity.ok("좋아요가 추가되었습니다.")
                    : ResponseEntity.badRequest().body("이미 좋아요한 이벤트입니다.");
        } catch (Exception e) {
            System.err.println("❌ 좋아요 추가 중 오류 발생: " + e.getMessage());
            return ResponseEntity.status(500).body("서버 오류: " + e.getMessage());
        }
    }

    /**
     * 특정 유저가 특정 이벤트에 좋아요 취소
     * DELETE /like_events/user/{userId}/event/{eventId}
     */
    @DeleteMapping("/user/{userId}/event/{eventId}")
    public ResponseEntity<String> removeLikeEvent(@PathVariable Long userId, @PathVariable Long eventId) {
        try {
            boolean isRemoved = likeEventService.removeLikeEvent(userId, eventId);
            return isRemoved
                    ? ResponseEntity.ok("좋아요가 삭제되었습니다.")
                    : ResponseEntity.badRequest().body("좋아요 상태가 아닙니다.");
        } catch (Exception e) {
            System.err.println("❌ 좋아요 삭제 중 오류 발생: " + e.getMessage());
            return ResponseEntity.status(500).body("서버 오류: " + e.getMessage());
        }
    }
}