package com.jwtPractise.controller;

import com.jwtPractise.Entity.AppDemoUser;
import com.jwtPractise.Entity.Review;
import com.jwtPractise.service.ReviewService;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/add-review")
    public ResponseEntity<Review> addReview(@RequestBody Review review,
                                            @RequestParam Long propertyId,
                                            @AuthenticationPrincipal AppDemoUser demoUser){
       Review savedReview= reviewService.addHotelReview(review,propertyId,demoUser);
       return new ResponseEntity<>(savedReview, HttpStatus.OK);
    }
}
