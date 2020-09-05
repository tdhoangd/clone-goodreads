package com.thanhdhoang.clonegoodreads.persistence.repositories;

import com.thanhdhoang.clonegoodreads.persistence.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book,Long> {

    Page<Book> findByTitleLikeIgnoreCaseOrIsbnLike(String title, String isbn, Pageable pageable);

//    List<Book> findByTitleLikeIgnoreCaseOrIsbnLike(String title, String isbn);
}
