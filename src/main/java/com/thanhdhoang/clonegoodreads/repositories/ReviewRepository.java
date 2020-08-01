package com.thanhdhoang.clonegoodreads.repositories;

import com.thanhdhoang.clonegoodreads.domain.Review;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends PagingAndSortingRepository<Review,Long> {
}
