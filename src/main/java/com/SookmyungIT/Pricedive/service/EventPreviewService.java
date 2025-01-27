package com.SookmyungIT.Pricedive.service;

import com.SookmyungIT.Pricedive.dto.EventPreview;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventPreviewService {

    public List<EventPreview> getEventPreviews(String category, String keyword, Boolean isLiked) {
        List<EventPreview> allPreviews = getMockData();

        List<EventPreview> filteredPreviews = new ArrayList<>();
        for (EventPreview preview : allPreviews) {
            boolean matches = true;

            if (category != null && !preview.getCategory().equalsIgnoreCase(category)) {
                matches = false;
            }
            if (keyword != null && !preview.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                matches = false;
            }
            if (isLiked != null && preview.isLiked() != isLiked) {
                matches = false;
            }

            if (matches) {
                filteredPreviews.add(preview);
            }
        }

        return filteredPreviews;
    }

    private List<EventPreview> getMockData() {
        List<EventPreview> mockData = new ArrayList<>();
        mockData.add(new EventPreview(1L, "Category1", "Event1", true));
        mockData.add(new EventPreview(2L, "Category2", "Event2", false));
        mockData.add(new EventPreview(3L, "Category1", "Another Event", true));
        return mockData;
    }
}