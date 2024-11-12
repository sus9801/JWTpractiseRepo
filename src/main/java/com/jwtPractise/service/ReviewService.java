package com.jwtPractise.service;

import com.jwtPractise.Entity.AppDemoUser;
import com.jwtPractise.Entity.Property;
import com.jwtPractise.Entity.Review;
import com.jwtPractise.repository.PropertyRepository;
import com.jwtPractise.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    private final PropertyRepository propertyRepository;

    public ReviewService(ReviewRepository reviewRepository,
                         PropertyRepository propertyRepository) {
        this.reviewRepository = reviewRepository;
        this.propertyRepository = propertyRepository;
    }

    public Review addHotelReview(Review review, Long propertyId, AppDemoUser demoUser) {
     Property property=propertyRepository.findById(propertyId).get();
     review.setProperty(property);
     review.setAppDemoUser(demoUser);
     Review savedReview=reviewRepository.save(review);
     return savedReview;
    }
}
