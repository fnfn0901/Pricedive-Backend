package com.SookmyungIT.Pricedive.service;

import com.SookmyungIT.Pricedive.model.Event;
import com.SookmyungIT.Pricedive.model.LikeEvent;
import com.SookmyungIT.Pricedive.model.User;
import com.SookmyungIT.Pricedive.repository.EventRepository;
import com.SookmyungIT.Pricedive.repository.LikeEventRepository;
import com.SookmyungIT.Pricedive.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeEventService {

    private final LikeEventRepository likeEventRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public LikeEventService(LikeEventRepository likeEventRepository, UserRepository userRepository, EventRepository eventRepository) {
        this.likeEventRepository = likeEventRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
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

    /**
     * 특정 유저가 특정 이벤트에 좋아요 추가
     */
    @Transactional
    public boolean addLikeEvent(Long userId, Long eventId) {
        if (likeEventRepository.existsByUser_IdAndEvent_Id(userId, eventId)) {
            return false;
        }

        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다. userId: " + userId));

            Event event = eventRepository.findById(eventId)
                    .orElseThrow(() -> new IllegalArgumentException("이벤트를 찾을 수 없습니다. eventId: " + eventId));

            LikeEvent likeEvent = new LikeEvent(user, event);
            likeEventRepository.save(likeEvent);
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println("❌ 오류 발생: " + e.getMessage());
            return false;
        }
    }

    /**
     * 특정 유저가 특정 이벤트에 좋아요 삭제
     */
    @Transactional
    public boolean removeLikeEvent(Long userId, Long eventId) {
        LikeEvent likeEvent = likeEventRepository.findByUser_IdAndEvent_Id(userId, eventId);
        if (likeEvent == null) {
            System.err.println("❌ 좋아요 기록이 존재하지 않음: userId = " + userId + ", eventId = " + eventId);
            return false;
        }

        likeEventRepository.delete(likeEvent);
        return true;
    }
}