package com.SookmyungIT.Pricedive.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "이벤트 미리보기 데이터")
public class EventDTO {
    @Schema(description = "이벤트 ID", example = "1")
    private Long eventId;

    @Schema(description = "카테고리", example = "Category1")
    private String category;

    @Schema(description = "이벤트 개수", example = "20")
    private int eventNums;

    @Schema(description = "이벤트 아이템", example = "네이버페이 쿠폰 1만 원권")
    private String eventItem;

    @Schema(description = "미리보기 이미지", example = "https://example.com/image.jpg")
    private String previewImg;

    @Schema(description = "비디오 ID", example = "100")
    private Long videoId;

    @Schema(description = "이벤트 종료 날짜", example = "2025-12-31T23:59:59")
    private LocalDateTime dateEnd;

    @Schema(description = "제목", example = "Event1")
    private String title;

    @Schema(description = "좋아요 여부", example = "true")
    private boolean liked;

    public EventDTO(Long eventId, String category, int eventNums, String eventItem, String previewImg, Long videoId, LocalDateTime dateEnd, String title, boolean liked) {
        this.eventId = eventId;
        this.category = category;
        this.eventNums = eventNums;
        this.eventItem = eventItem;
        this.previewImg = previewImg;
        this.videoId = videoId;
        this.dateEnd = dateEnd;
        this.title = title;
        this.liked = liked;
    }

    public Long getEventId() {
        return eventId;
    }

    public String getCategory() {
        return category;
    }

    public int getEventNums() {
        return eventNums;
    }

    public String getEventItem() {
        return eventItem;
    }

    public String getPreviewImg() {
        return previewImg;
    }

    public Long getVideoId() {
        return videoId;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public String getTitle() {
        return title;
    }

    public boolean isLiked() {
        return liked;
    }
}