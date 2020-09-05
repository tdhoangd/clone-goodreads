package com.thanhdhoang.clonegoodreads.services;

import com.thanhdhoang.clonegoodreads.persistence.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService extends CrudService<Review, Long> {

    // Page<Book> findByKeyword(String q, Pageable pageable);
    Page<Review> findByBookId(Long id, Pageable pageable);
}
