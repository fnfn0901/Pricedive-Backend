package com.SookmyungIT.Pricedive.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "비디오 상세 데이터")
public class VideoDTO {
    @Schema(description = "비디오 ID", example = "1")
    private Long id;

    @Schema(description = "비디오 제목", example = "Video Title")
    private String title;

    @Schema(description = "채널 ID", example = "channel123")
    private String channelId;

    @Schema(description = "채널 이미지", example = "https://example.com/channel.jpg")
    private String channelImg;

    @Schema(description = "비디오 설명", example = "This is a video description.")
    private String description;

    @Schema(description = "비디오 태그", example = "['Tech', 'Tutorial']")
    private String tags;

    @Schema(description = "비디오 URL", example = "https://youtube.com/video123")
    private String urlLink;

    @Schema(description = "비디오 시작 날짜", example = "2025-01-27")
    private String dateStart;

    @Schema(description = "비디오 종료 날짜", example = "2025-02-10")
    private String dateEnd;

    @Schema(description = "요약 설명", example = "This is a summarized description.")
    private String summarizedDescription;

    public VideoDTO() {}

    public VideoDTO(Long id, String title, String channelId, String channelImg, String description, String tags, String urlLink, String dateStart, String dateEnd, String summarizedDescription) {
        this.id = id;
        this.title = title;
        this.channelId = channelId;
        this.channelImg = channelImg;
        this.description = description;
        this.tags = tags;
        this.urlLink = urlLink;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.summarizedDescription = summarizedDescription;
    }

    // Getter & Setter
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
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelImg() {
        return channelImg;
    }

    public void setChannelImg(String channelImg) {
        this.channelImg = channelImg;
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
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getSummarizedDescription() {
        return summarizedDescription;
    }

    public void setSummarizedDescription(String summarizedDescription) {
        this.summarizedDescription = summarizedDescription;
    }
}