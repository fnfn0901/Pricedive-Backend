package com.SookmyungIT.Pricedive.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class EventPreview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    @NotNull
    private Event event;

    @NotNull
    private String event_item;

    private String preview_img;
    private String category;

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
}