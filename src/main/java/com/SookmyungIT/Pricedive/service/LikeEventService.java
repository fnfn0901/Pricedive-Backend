package com.SookmyungIT.Pricedive.service;

import com.SookmyungIT.Pricedive.dto.LikedEventResponse;
import com.SookmyungIT.Pricedive.model.Event;
import com.SookmyungIT.Pricedive.model.LikeEvent;
import com.SookmyungIT.Pricedive.model.User;
import com.SookmyungIT.Pricedive.repository.EventRepository;
import com.SookmyungIT.Pricedive.repository.LikeEventRepository;
import com.SookmyungIT.Pricedive.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    public List<LikedEventResponse> getLikedEventsByUserId(Long userId, boolean ongoing) {
        LocalDate today = LocalDate.now();

        return likeEventRepository.findByUser_Id(userId)
                .stream()
                .map(likeEvent -> {
                    Event event = eventRepository.findByVideoId(likeEvent.getVideoId())
                            .orElse(null);
                    if (event != null) {
                        return new LikedEventResponse(event.getVideoId(), event.getEventItem(), event.getPreviewImg(), event.getDateEnd());
                    }
                    return null;
                })
                .filter(event -> event != null && (!ongoing || event.getDateEnd().toLocalDate().isAfter(today)))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean addLikeEvent(Long userId, Long videoId) {
        try {
            if (likeEventRepository.existsByUser_IdAndVideoId(userId, videoId)) {
                return false;
            }

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다. userId: " + userId));

            Event event = eventRepository.findByVideoId(videoId)
                    .orElseThrow(() -> new IllegalArgumentException("이벤트를 찾을 수 없습니다. videoId: " + videoId));

            LikeEvent likeEvent = new LikeEvent(user, videoId);
            likeEventRepository.save(likeEvent);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public boolean removeLikeEvent(Long userId, Long videoId) {
        var likeEventOpt = likeEventRepository.findByUser_IdAndVideoId(userId, videoId);

        if (likeEventOpt.isEmpty()) {
            return false;
        }

        likeEventRepository.delete(likeEventOpt.get());
        return true;
    }
}