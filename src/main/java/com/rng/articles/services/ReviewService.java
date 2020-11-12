package com.rng.articles.services;

import com.rng.articles.entities.Review;
import com.rng.articles.repositories.ReviewRepository;
import com.rng.articles.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review findById(Long id){
        return reviewRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found, ID: " + id));
    }
}