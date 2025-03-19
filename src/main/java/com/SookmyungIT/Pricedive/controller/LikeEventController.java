package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.dto.LikedEventResponse;
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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LikedEventResponse>> getLikedEventsByUserId(
            @PathVariable Long userId,
            @RequestParam(value = "ongoing", required = false, defaultValue = "false") boolean ongoing) {

        List<LikedEventResponse> likedEvents = likeEventService.getLikedEventsByUserId(userId, ongoing);
        return ResponseEntity.ok(likedEvents);
    }

    @PostMapping("/user/{userId}/video/{videoId}")
    public ResponseEntity<String> addLikeEvent(@PathVariable Long userId, @PathVariable Long videoId) {
        try {
            boolean isAdded = likeEventService.addLikeEvent(userId, videoId);
            return isAdded
                    ? ResponseEntity.ok("좋아요가 추가되었습니다.")
                    : ResponseEntity.badRequest().body("이미 좋아요한 비디오입니다.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("서버 오류: " + e.getMessage());
        }
    }

    @DeleteMapping("/user/{userId}/video/{videoId}")
    public ResponseEntity<String> removeLikeEvent(@PathVariable Long userId, @PathVariable Long videoId) {
        try {
            boolean isRemoved = likeEventService.removeLikeEvent(userId, videoId);
            return isRemoved
                    ? ResponseEntity.ok("좋아요가 삭제되었습니다.")
                    : ResponseEntity.badRequest().body("좋아요 상태가 아닙니다.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("서버 오류: " + e.getMessage());
        }
    }
}