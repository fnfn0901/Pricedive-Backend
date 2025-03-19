package com.SookmyungIT.Pricedive.model;

import jakarta.persistence.*;

@Entity
@Table(name = "like_event", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "video_id"})
})
public class LikeEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @Column(name = "video_id", nullable = false)
    private Long videoId;

    public LikeEvent() {}

    public LikeEvent(User user, Long videoId) {
        this.user = user;
        this.videoId = videoId;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Long getVideoId() {
        return videoId;
    }
}