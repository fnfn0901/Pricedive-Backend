package com.SookmyungIT.Pricedive.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "공통 API 요청 포맷")
public class APIRequest {
    @Schema(description = "요청을 보낸 유저의 ID", example = "user123")
    private String userId;

    @Schema(description = "요청을 보낸 유저의 인증 토큰", example = "eyJhbGciOiJIUzI1NiIs...")
    private String token;

    public APIRequest() {
    }

    public APIRequest(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}