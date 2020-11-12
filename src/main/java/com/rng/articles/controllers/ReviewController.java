package com.rng.articles.controllers;

import com.rng.articles.entities.Review;
import com.rng.articles.services.ReviewService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Review> findById(@PathVariable Long id){
        return ResponseEntity.ok(reviewService.findById(id));
    }
}