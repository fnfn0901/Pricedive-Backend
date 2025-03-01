package com.SookmyungIT.Pricedive.repository;

import com.SookmyungIT.Pricedive.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // ✅ 특정 카테고리의 이벤트 가져오기
    List<Event> findByCategory(String category);

    // ✅ 특정 검색어가 제목에 포함된 이벤트 가져오기 (대소문자 구분 없이)
    List<Event> findByTitleContainingIgnoreCase(String search);

    // ✅ 특정 카테고리 내에서 검색어가 포함된 이벤트 가져오기
    List<Event> findByCategoryAndTitleContainingIgnoreCase(String category, String search);
}