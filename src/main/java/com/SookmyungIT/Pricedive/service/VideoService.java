package com.SookmyungIT.Pricedive.service;

import com.SookmyungIT.Pricedive.dto.VideoDTO;
import com.SookmyungIT.Pricedive.model.Video;
import com.SookmyungIT.Pricedive.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Optional<VideoDTO> getVideoById(Long id) {
        return videoRepository.findById(id)
                .map(video -> new VideoDTO(
                        video.getId(),
                        video.getTitle(),
                        video.getChannelId(),
                        video.getChannelImg(),
                        video.getDescription(),
                        parseTags(video.getTags()),
                        video.getUrlLink(),
                        video.getDateStart(),
                        video.getDateEnd(),
                        video.getSummarizedDescription()
                ));
    }

    private List<String> parseTags(String tags) {
        if (tags == null || tags.trim().isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.stream(tags.split("\\|"))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}