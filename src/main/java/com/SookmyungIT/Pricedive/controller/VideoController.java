package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.dto.APIResponse;
import com.SookmyungIT.Pricedive.dto.VideoDTO;
import com.SookmyungIT.Pricedive.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<VideoDTO>> getVideoById(@PathVariable Long id) {
        VideoDTO video = videoService.getVideoById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 비디오를 찾을 수 없습니다."));
        return ResponseEntity.ok(APIResponse.success(video, "비디오 조회 성공"));
    }
}