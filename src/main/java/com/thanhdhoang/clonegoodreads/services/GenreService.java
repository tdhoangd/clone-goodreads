package com.thanhdhoang.clonegoodreads.services;

import com.thanhdhoang.clonegoodreads.commands.GenreCommand;
import com.thanhdhoang.clonegoodreads.persistence.model.Genre;
import javassist.NotFoundException;

import java.util.Set;

public interface GenreService extends CrudService<Genre, Long> {

    Set<GenreCommand> listAllGenres();

    Genre findByName(String name) throws NotFoundException;

    GenreCommand findCommandByName(String name) throws NotFoundException;
}
