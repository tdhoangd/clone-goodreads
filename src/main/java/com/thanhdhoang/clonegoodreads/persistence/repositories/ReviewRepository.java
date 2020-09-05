package com.thanhdhoang.clonegoodreads.persistence.repositories;

import com.thanhdhoang.clonegoodreads.persistence.domain.Book;
import com.thanhdhoang.clonegoodreads.persistence.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
//        Page<Book> findByTitleLikeIgnoreCaseOrIsbnLike(String title, String isbn, Pageable pageable);
//    Page<Review> findByBookIsdEquals(Long id, Pageable pageable);

    Page<Review> findByBookId(Long id, Pageable pageable);
}


