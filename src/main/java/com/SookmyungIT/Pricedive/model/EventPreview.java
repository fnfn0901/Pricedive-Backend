package com.SookmyungIT.Pricedive.model;

import jakarta.persistence.*;

@Entity
public class EventPreview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    private String event_item;

    private String preview_img;

    private String category;

    private String channel_img;

    private String date_end;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getEventItem() {
        return event_item;
    }

    public void setEventItem(String eventItem) {
        this.event_item = event_item;
    }

    public String getPreviewImg() {
        return preview_img;
    }

    public void setPreviewImg(String previewImg) {
        this.preview_img = preview_img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChannelImg() {
        return channel_img;
    }

    public void setChannelImg(String channelImg) {
        this.channel_img = channelImg;
    }

    public String getDateEnd() {
        return date_end;
    }

    public void setDateEnd(String dateEnd) {
        this.date_end = dateEnd;
    }
}