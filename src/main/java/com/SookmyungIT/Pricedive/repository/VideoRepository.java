package com.SookmyungIT.Pricedive.repository;

import com.SookmyungIT.Pricedive.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}