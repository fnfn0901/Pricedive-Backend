package com.SookmyungIT.Pricedive.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LikeEventService {

    private final Map<String, List<Long>> mockLikeData = new HashMap<>();

    public LikeEventService() {
        // 목데이터 초기화
        mockLikeData.put("user1", Arrays.asList(1L, 2L, 3L));
        mockLikeData.put("user2", Arrays.asList(2L, 4L));
        mockLikeData.put("user3", Collections.singletonList(5L));
    }

    public List<Long> getLikedEventIdsByUserId(String userId) {
        return mockLikeData.getOrDefault(userId, Collections.emptyList());
    }
}