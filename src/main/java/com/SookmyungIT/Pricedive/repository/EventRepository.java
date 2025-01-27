package com.SookmyungIT.Pricedive.repository;

import com.SookmyungIT.Pricedive.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE " +
            "(:category IS NULL OR e.id IN (SELECT ep.event.id FROM EventPreview ep WHERE ep.category = :category)) " +
            "AND (:keyword IS NULL OR e.title LIKE %:keyword% OR e.description LIKE %:keyword%) " +
            "AND (:userId IS NULL OR e.id IN (SELECT le.event.id FROM LikeEvent le WHERE le.user.id = :userId))")
    List<Event> findByFilters(@Param("category") String category,
                              @Param("keyword") String keyword,
                              @Param("userId") Long userId);
}