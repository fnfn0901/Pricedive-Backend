package com.SookmyungIT.Pricedive.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LikeEventService {

    private final Map<String, List<Long>> likeData;

    public LikeEventService() {
        this.likeData = initializeLikeData();
    }

    public List<Long> getLikedEventIdsByUserId(String userId) {
        return likeData.getOrDefault(userId, Collections.emptyList());
    }

    private Map<String, List<Long>> initializeLikeData() {
        Map<String, List<Long>> data = new HashMap<>();
        data.put("user1", Arrays.asList(1L, 2L, 3L));
        data.put("user2", Arrays.asList(2L, 4L));
        data.put("user3", Collections.singletonList(5L));
        return data;
    }
}