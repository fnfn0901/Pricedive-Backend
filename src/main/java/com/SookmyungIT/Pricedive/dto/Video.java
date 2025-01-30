package com.SookmyungIT.Pricedive.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "이벤트 상세 데이터")
public class Video {
    @Schema(description = "이벤트 ID", example = "1")
    private Long id;

    @Schema(description = "이벤트 이름", example = "Event Name")
    private String name;

    @Schema(description = "이벤트 설명", example = "This is a detailed event description.")
    private String description;

    @Schema(description = "이벤트 날짜", example = "2025-01-27")
    private String eventDate;

    public Video() {
    }

    public Video(Long id, String name, String description, String date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
}