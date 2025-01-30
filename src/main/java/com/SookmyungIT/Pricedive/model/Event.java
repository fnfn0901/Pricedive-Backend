package com.SookmyungIT.Pricedive.model;

import jakarta.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    private Long event_id;

    @Column(nullable = false)
    private int event_nums;
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

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
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
        return event_item;
    }

    public void setEventItem(String event_item) {
        this.event_item = event_item;
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
}
