package com.SookmyungIT.Pricedive.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long event_id;
    private int event_nums;

    @Column(name = "event_item")
    private String eventItem;

    private String preview_img;
    private String category;
    private Long video_id;
    private String channel_img;

    @Column(name = "date_end", nullable = false)
    private LocalDateTime dateEnd;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return event_id;
    }

    public void setEventId(Long event_id) {
        this.event_id = event_id;
    }

    public int getEventNums() {
        return event_nums;
    }

    public void setEventNums(int event_nums) {
        this.event_nums = event_nums;
    }

    public String getEventItem() {
        return eventItem;
    }

    public void setEventItem(String eventItem) {
        this.eventItem = eventItem;
    }

    public String getPreviewImg() {
        return preview_img;
    }

    public void setPreviewImg(String preview_img) {
        this.preview_img = preview_img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getVideoId() {
        return video_id;
    }

    public void setVideoId(Long video_id) {
        this.video_id = video_id;
    }

    public String getChannelImg() {
        return channel_img;
    }

    public void setChannelImg(String channel_img) {
        this.channel_img = channel_img;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }
}