package com.thanhdhoang.clonegoodreads.services;

import com.thanhdhoang.clonegoodreads.persistence.domain.Book;

import java.util.Set;

public interface BookService extends CrudService<Book, Long> {

    // q: is isbn or title
    Set<Book> findByKeyword(String q);

}
