package com.SookmyungIT.Pricedive.service;

import com.SookmyungIT.Pricedive.repository.LikeEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeEventService {

    private final LikeEventRepository likeEventRepository;

    public LikeEventService(LikeEventRepository likeEventRepository) {
        this.likeEventRepository = likeEventRepository;
    }

    /**
     * 특정 유저가 좋아요한 이벤트 ID 목록 조회
     */
    public List<Long> getLikedEventIdsByUserId(Long userId) {
        return likeEventRepository.findByUser_Id(userId)
                .stream()
                .map(likeEvent -> likeEvent.getEvent().getId())
                .collect(Collectors.toList());
    }
}