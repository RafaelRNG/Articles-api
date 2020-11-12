package com.rng.articles.controllers;

import com.rng.articles.entities.Rating;
import com.rng.articles.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Rating> findById(@PathVariable Long id){
        return ResponseEntity.ok(ratingService.findById(id));
    }
}