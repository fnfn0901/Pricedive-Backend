package com.SookmyungIT.Pricedive.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Service
public class LikeEventService {

    private final Map<Long, List<Long>> likeData;

    public LikeEventService() {
        this.likeData = initializeLikeData();
    }

    public List<Long> getLikedEventIdsByUserId(Long userId) {
        return likeData.getOrDefault(userId, Collections.emptyList());
    }

    private Map<Long, List<Long>> initializeLikeData() {
        return new HashMap<>();
    }
}