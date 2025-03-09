package com.SookmyungIT.Pricedive.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String channel_id;
    private String channel_img;
    private String description;
    private String tags;
    private String url_link;
    private String date_start;
    private String date_end;
    private String summarized_description;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelId() {
        return channel_id;
    }

    public void setChannelId(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannelImg() {
        return channel_img;
    }

    public void setChannelImg(String channel_img) {
        this.channel_img = channel_img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUrlLink() {
        return url_link;
    }

    public void setUrlLink(String url_link) {
        this.url_link = url_link;
    }

    public String getDateStart() {
        return date_start;
    }

    public void setDateStart(String date_start) {
        this.date_start = date_start;
    }

    public String getDateEnd() {
        return date_end;
    }

    public void setDateEnd(String date_end) {
        this.date_end = date_end;
    }

    public String getSummarizedDescription() {
        return summarized_description;
    }

    public void setSummarizedDescription(String summarized_description) {
        this.summarized_description = summarized_description;
    }
}