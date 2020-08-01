package com.thanhdhoang.clonegoodreads.repositories;

import com.thanhdhoang.clonegoodreads.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {

    List<Author> findByNameLike(String name);
}
