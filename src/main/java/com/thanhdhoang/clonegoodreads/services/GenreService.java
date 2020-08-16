package com.thanhdhoang.clonegoodreads.services;

import com.thanhdhoang.clonegoodreads.persistence.model.Genre;

public interface GenreService extends CrudService<Genre, Long> {

    Genre findByName(String name);
}
