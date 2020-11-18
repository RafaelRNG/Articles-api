package com.rng.articles.services;

import com.rng.articles.entities.Rating;
import com.rng.articles.repositories.RatingRepository;
import com.rng.articles.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> findAll(){
        return ratingRepository.findAll();
    }

    public Page<Rating> pagination(Integer page, Integer linesPerPage, String direction, String orderBy){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        return ratingRepository.findAll(pageRequest);
    }

    public Rating findById(Long id){
        return ratingRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found, ID: " + id));
    }

    public void save(Rating rating){
        ratingRepository.save(rating);
    }

    public Rating update(Long id, Rating rating){
        Rating ratingUpdate = ratingRepository.findById(id).get();
        rating.setId(ratingUpdate.getId());

        ratingRepository.save(rating);
        return rating;
    }


    public void deleteById(Long id){
        ratingRepository.deleteById(id);
    }
}