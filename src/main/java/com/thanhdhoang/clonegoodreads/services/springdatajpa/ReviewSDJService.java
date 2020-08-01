package com.thanhdhoang.clonegoodreads.services.springdatajpa;

import com.thanhdhoang.clonegoodreads.domain.Review;
import com.thanhdhoang.clonegoodreads.repositories.ReviewRepository;
import com.thanhdhoang.clonegoodreads.services.ReviewService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ReviewSDJService implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewSDJService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Set<Review> findAll() {
        Set<Review> reviews = new HashSet<>();
        reviewRepository.findAll().forEach(reviews::add);
        return reviews;
    }

    @Override
    public Review findById(Long aLong) {
        return reviewRepository.findById(aLong).orElse(null);
    }

    @Override
    public Review save(Review object) {
        return reviewRepository.save(object);
    }

    @Override
    public void delete(Review object) {
        reviewRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        reviewRepository.deleteById(aLong);
    }
}
