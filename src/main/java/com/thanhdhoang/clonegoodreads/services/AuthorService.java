package com.thanhdhoang.clonegoodreads.services;

import com.thanhdhoang.clonegoodreads.persistence.domain.Author;
import java.util.Set;

public interface AuthorService extends CrudService<Author, Long> {

//    Genre findByName(String name);

    Set<Author> findAllByNameLikeIgnoreCase(String name);

}
