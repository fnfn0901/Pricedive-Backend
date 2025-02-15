package com.SookmyungIT.Pricedive.repository;

import com.SookmyungIT.Pricedive.model.LikeEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LikeEventRepository extends JpaRepository<LikeEvent, Long> {
    List<LikeEvent> findByUser_Id(Long userId);

    boolean existsByUser_IdAndEvent_Id(Long userId, Long eventId);

    LikeEvent findByUser_IdAndEvent_Id(Long userId, Long eventId);
}