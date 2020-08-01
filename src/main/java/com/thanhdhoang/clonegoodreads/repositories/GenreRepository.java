package com.thanhdhoang.clonegoodreads.repositories;

import com.thanhdhoang.clonegoodreads.domain.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre,Long> {

    Genre findByGenre(String genre);
}
