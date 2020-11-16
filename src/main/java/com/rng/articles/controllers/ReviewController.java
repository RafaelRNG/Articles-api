package com.rng.articles.controllers;

import com.rng.articles.entities.Review;
import com.rng.articles.services.ReviewService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> findAll(){
        return ResponseEntity.ok(reviewService.findAll());
    }

    @GetMapping(path = "/page")
    public ResponseEntity<Page<Review>> pagination(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(name = "direction", defaultValue = "ASC") String direction,
            @RequestParam(name = "orderBy", defaultValue = "reviewTitle") String orderBy){

        Page<Review> reviewPage = reviewService.pagination(page, linesPerPage, direction, orderBy);

        return ResponseEntity.ok(reviewPage);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Review> findById(@PathVariable Long id){
        return ResponseEntity.ok(reviewService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Review review){
        reviewService.save(review);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(review.getId()).toUri()).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Review review){
        reviewService.update(id, review);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        reviewService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}