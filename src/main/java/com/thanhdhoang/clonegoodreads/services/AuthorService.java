package com.thanhdhoang.clonegoodreads.services;

import com.thanhdhoang.clonegoodreads.persistence.domain.Author;
import java.util.List;

public interface AuthorService extends CrudService<Author, Long> {

//    Genre findByName(String name);

    List<Author> findAllByNameLikeIgnoreCase(String name);

}
