package com.SookmyungIT.Pricedive.dto;

import java.time.LocalDateTime;

public class LikedEventResponse {
    private Long eventId;
    private String eventItem;
    private String previewImg;
    private LocalDateTime dateEnd;

    public LikedEventResponse(Long eventId, String eventItem, String previewImg, LocalDateTime dateEnd) {
        this.eventId = eventId;
        this.eventItem = eventItem;
        this.previewImg = previewImg;
        this.dateEnd = dateEnd;
    }

    public Long getEventId() {
        return eventId;
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