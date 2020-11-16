package com.rng.articles.services;

import com.rng.articles.entities.Review;
import com.rng.articles.repositories.ReviewRepository;
import com.rng.articles.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findAll(){
        return reviewRepository.findAll();
    }

    public Page<Review> pagination(Integer page, Integer linesPerPage, String direction, String orderBy){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        return reviewRepository.findAll(pageRequest);
    }

    public Review findById(Long id){
        return reviewRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found, ID: " + id));
    }

    public void save(Review review){
        reviewRepository.save(review);
    }

    public Review update(Long id, Review review){
        Review reviewUpdate = reviewRepository.findById(id).get();
        review.setId(reviewUpdate.getId());
        reviewRepository.save(review);
        return review;
    }

    public void deleteById(Long id){
        reviewRepository.deleteById(id);
    }
}