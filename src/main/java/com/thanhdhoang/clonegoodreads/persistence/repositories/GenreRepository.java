package com.thanhdhoang.clonegoodreads.persistence.repositories;

import com.thanhdhoang.clonegoodreads.persistence.domain.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends CrudRepository<Genre,Long> {

    Optional<Genre> findByNameIgnoreCase(String name);
}
