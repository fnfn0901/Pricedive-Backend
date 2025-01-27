package com.SookmyungIT.Pricedive.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "공통 API 응답 포맷")
public class APIResponse<T> {
    @Schema(description = "HTTP 상태 코드", example = "200")
    private int statusCode;

    @Schema(description = "응답 메시지", example = "요청이 성공적으로 처리되었습니다.")
    private String message;

    @Schema(description = "응답 데이터")
    private T data;

    public APIResponse() {
    }

    public APIResponse(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    // 성공 응답 유틸리티 메서드
    public static <T> APIResponse<T> success(T data, String message) {
        return new APIResponse<>(200, message, data);
    }

    // 에러 응답 유틸리티 메서드 (클라이언트 에러)
    public static <T> APIResponse<T> clientError(int statusCode, String message) {
        return new APIResponse<>(statusCode, message, null);
    }

    // 에러 응답 유틸리티 메서드 (서버 에러)
    public static <T> APIResponse<T> serverError(String message) {
        return new APIResponse<>(500, message, null);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}