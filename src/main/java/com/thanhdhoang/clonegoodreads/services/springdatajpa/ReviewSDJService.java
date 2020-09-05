package com.thanhdhoang.clonegoodreads.services.springdatajpa;

import com.thanhdhoang.clonegoodreads.exception.NotFoundException;
import com.thanhdhoang.clonegoodreads.persistence.domain.Review;
import com.thanhdhoang.clonegoodreads.persistence.repositories.BookRepository;
import com.thanhdhoang.clonegoodreads.persistence.repositories.ReviewRepository;
import com.thanhdhoang.clonegoodreads.services.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ReviewSDJService implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    public ReviewSDJService(ReviewRepository reviewRepository, BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Set<Review> findAll() {
        Set<Review> reviews = new HashSet<>();
        reviewRepository.findAll().forEach(reviews::add);
        return reviews;
    }

    @Override
    public Review findById(Long aLong) {
        Optional<Review> optionalReview = reviewRepository.findById(aLong);
        if (optionalReview.isEmpty())
            throw new NotFoundException("Review by id " + aLong + " not found");
        return optionalReview.get();
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

    @Override
    public Page<Review> findByBookId(Long id, Pageable pageable) {
        //         return bookRepository.findByTitleLikeIgnoreCaseOrIsbnLike(q, q, pageable);

        return reviewRepository.findByBookId(id, pageable);
    }
}
