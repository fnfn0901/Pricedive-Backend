package com.SookmyungIT.Pricedive.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "이벤트 미리보기 데이터")
public class Event {
    @Schema(description = "이벤트 ID", example = "1")
    private Long id;

    @Schema(description = "카테고리", example = "Category1")
    private String category;

    @Schema(description = "제목", example = "Event1")
    private String title;

    @Schema(description = "좋아요 여부", example = "true")
    private boolean liked;

    public Event() {
    }

    public Event(Long id, String category, String title, boolean liked) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.liked = liked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}