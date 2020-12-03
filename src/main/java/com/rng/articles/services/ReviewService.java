package com.rng.articles.services;

import com.rng.articles.dto.ReviewDTO;
import com.rng.articles.entities.Article;
import com.rng.articles.entities.Review;
import com.rng.articles.entities.User;
import com.rng.articles.repositories.ReviewRepository;
import com.rng.articles.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

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
        try{
            reviewRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ObjectNotFoundException("Object not found, ID: " + id);
        }
    }

    public Review fromDTO(ReviewDTO reviewDTO){
        User user = userService.findById(reviewDTO.getUser());
        Article article = articleService.findById(reviewDTO.getArticle());

        return new Review(reviewDTO.getId(), new Date(), reviewDTO.getReviewTitle(), reviewDTO.getReviewBody(), user, article);
    }
}