package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.model.Video;
import com.SookmyungIT.Pricedive.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id) {
        Video video = videoService.getVideoById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 비디오를 찾을 수 없습니다."));
        return ResponseEntity.ok(video);
    }
}