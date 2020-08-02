package com.thanhdhoang.clonegoodreads.converters;

import com.thanhdhoang.clonegoodreads.commands.GenreCommand;
import com.thanhdhoang.clonegoodreads.domain.Genre;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GenreCommandToGenre implements Converter<GenreCommand, Genre> {

    @Override
    public Genre convert(GenreCommand source) {
        if (source == null) {
            return null;
        }

        final Genre genre = new Genre();
        genre.setId(source.getId());
        genre.setGenre(source.getGenre());

        return genre;
    }
}
