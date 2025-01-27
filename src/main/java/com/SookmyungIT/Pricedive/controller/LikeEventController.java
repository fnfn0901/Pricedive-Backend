package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.dto.APIResponse;
import com.SookmyungIT.Pricedive.service.LikeEventService;
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
    public APIResponse<List<Long>> getLikedEventIds(@PathVariable String userId) {
        List<Long> likedEventIds = likeEventService.getLikedEventIdsByUserId(userId);
        return new APIResponse<>(true, "좋아요한 이벤트 ID 리스트를 성공적으로 가져왔습니다.", likedEventIds);
    }
}