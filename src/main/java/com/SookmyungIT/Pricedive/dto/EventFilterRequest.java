package com.SookmyungIT.Pricedive.dto;

public class EventFilterRequest {
    private String category; // 필터링할 카테고리
    private String keyword;  // 검색 키워드
    private Long userId;     // 좋아요 여부 필터링을 위한 유저 ID

    // Getters and Setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}