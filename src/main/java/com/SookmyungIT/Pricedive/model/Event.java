package com.SookmyungIT.Pricedive.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Column(name = "video_id")
    private Long videoId;

    private String channel_img;

    @Column(name = "channel_id")
    private String channelId;

    @Column(name = "date_end")
    private String dateEndRaw;

    @Transient
    private LocalDateTime dateEnd;

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
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getChannelImg() {
        return channel_img;
    }

    public void setChannelImg(String channel_img) {
        this.channel_img = channel_img;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public LocalDateTime getDateEnd() {
        if (dateEnd == null) {
            try {
                if (dateEndRaw == null || dateEndRaw.equals("0000-00-00 00:00:00")) {
                    dateEnd = LocalDateTime.of(2000, 1, 1, 0, 0);
                } else {
                    dateEnd = LocalDateTime.parse(dateEndRaw, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                }
            } catch (Exception e) {
                dateEnd = LocalDateTime.of(2000, 1, 1, 0, 0);
            }
        }
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
        this.dateEndRaw = dateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}