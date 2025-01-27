package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.dto.APIResponse;
import com.SookmyungIT.Pricedive.dto.EventPreview;
import com.SookmyungIT.Pricedive.service.EventPreviewService;
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
    public APIResponse<List<EventPreview>> getEventPreviews(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Boolean isLiked
    ) {
        List<EventPreview> previews = eventPreviewService.getEventPreviews(category, keyword, isLiked);
        return new APIResponse<>(true, "이벤트 미리보기 리스트를 성공적으로 가져왔습니다.", previews);
    }
}