package com.SookmyungIT.Pricedive.dto;

import java.time.LocalDateTime;

public class LikedEventResponse {
    private Long videoId;
    private String eventItem;
    private String previewImg;
    private LocalDateTime dateEnd;

    public LikedEventResponse(Long videoId, String eventItem, String previewImg, LocalDateTime dateEnd) {
        this.videoId = videoId;
        this.eventItem = eventItem;
        this.previewImg = previewImg;
        this.dateEnd = dateEnd;
    }

    public Long getVideoId() {
        return videoId;
    }

    public String getEventItem() {
        return eventItem;
    }

    public String getPreviewImg() {
        return previewImg;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }
}