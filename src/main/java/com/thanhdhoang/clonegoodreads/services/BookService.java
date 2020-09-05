package com.thanhdhoang.clonegoodreads.services;

import com.thanhdhoang.clonegoodreads.persistence.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface BookService extends CrudService<Book, Long> {

    // q: is isbn or title
    Page<Book> findByKeyword(String q, Pageable pageable);

}
