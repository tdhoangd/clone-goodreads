package com.thanhdhoang.clonegoodreads.persistence.repositories;

import com.thanhdhoang.clonegoodreads.persistence.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {

    List<Author> findByNameLike(String name);

    List<Author> findByNameLikeIgnoreCase(String name);
}
