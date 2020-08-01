package com.thanhdhoang.clonegoodreads.repositories;

import com.thanhdhoang.clonegoodreads.domain.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book,Long> {

    List<Book> findByTitleLike(String title);
}
