package com.thanhdhoang.clonegoodreads.persistence.repositories;

import com.thanhdhoang.clonegoodreads.persistence.domain.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book,Long> {

    List<Book> findByTitleLikeIgnoreCase(String title);

    List<Book> findByIsbnLike(String isbn);
}
