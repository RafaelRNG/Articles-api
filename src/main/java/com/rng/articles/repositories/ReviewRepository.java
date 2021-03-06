package com.rng.articles.repositories;

import com.rng.articles.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByUserId(Long id);

    List<Review> findByArticleId(Long id);
}
