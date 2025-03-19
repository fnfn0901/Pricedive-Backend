package com.SookmyungIT.Pricedive.repository;

import com.SookmyungIT.Pricedive.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByCategory(String category);
    List<Event> findByEventItemContainingIgnoreCase(String search);
    List<Event> findByCategoryAndEventItemContainingIgnoreCase(String category, String search);

    @Query("SELECT e FROM Event e WHERE LOWER(e.eventItem) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.channelId) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Event> searchByEventItemOrChannelId(String search);

    @Query("SELECT e FROM Event e WHERE e.category = :category AND (LOWER(e.eventItem) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(e.channelId) LIKE LOWER(CONCAT('%', :search, '%')))")
    List<Event> searchByCategoryAndEventItemOrChannelId(String category, String search);

    Optional<Event> findByVideoId(Long videoId);
}