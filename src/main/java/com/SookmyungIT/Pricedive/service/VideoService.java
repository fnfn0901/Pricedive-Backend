package com.SookmyungIT.Pricedive.service;

import com.SookmyungIT.Pricedive.model.Video;
import com.SookmyungIT.Pricedive.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }
}