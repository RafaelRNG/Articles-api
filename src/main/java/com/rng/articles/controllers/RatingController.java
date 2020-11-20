package com.rng.articles.controllers;

import com.rng.articles.dto.RatingDTO;
import com.rng.articles.entities.Rating;
import com.rng.articles.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping
    public ResponseEntity<List<Rating>> findAll(){
        return ResponseEntity.ok(ratingService.findAll());
    }

    @GetMapping(path = "/page")
    public ResponseEntity<Page<Rating>> pagination(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(name = "direction", defaultValue = "ASC") String diretion,
            @RequestParam(name = "orderBy", defaultValue = "id") String orderBy){

        return ResponseEntity.ok(ratingService.pagination(page, linesPerPage, diretion, orderBy));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Rating> findById(@PathVariable Long id){
        return ResponseEntity.ok(ratingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody RatingDTO ratingDTO){
        Rating rating = ratingService.fromDTO(ratingDTO);

        ratingService.save(rating);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rating.getId()).toUri()).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Rating> update(@PathVariable Long id, @Valid @RequestBody RatingDTO ratingDTO){
        Rating rating = ratingService.fromDTO(ratingDTO);

        ratingService.update(id, rating);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        ratingService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}