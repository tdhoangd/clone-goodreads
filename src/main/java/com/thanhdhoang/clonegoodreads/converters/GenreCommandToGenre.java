package com.thanhdhoang.clonegoodreads.converters;

import com.thanhdhoang.clonegoodreads.commands.GenreCommand;
import com.thanhdhoang.clonegoodreads.domain.Genre;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GenreCommandToGenre implements Converter<GenreCommand, Genre> {

    private final AuthorCommandToAuthor authorConverter;
    private final BookCommandToBook bookConverter;

    public GenreCommandToGenre(AuthorCommandToAuthor authorConverter,
                               BookCommandToBook bookConverter) {
        this.authorConverter = authorConverter;
        this.bookConverter = bookConverter;
    }


    @Override
    public Genre convert(GenreCommand source) {
        if (source == null) {
            return null;
        }

        final Genre genre = new Genre();
        genre.setId(source.getId());
        genre.setGenre(source.getGenre());

        if (source.getAuthors() != null && source.getAuthors().size() > 0) {
            source.getAuthors().forEach(command ->
                    genre.getAuthors().add(authorConverter.convert(command)));
        }

        if (source.getBooks() != null && source.getBooks().size() >0) {
            source.getBooks().forEach(command ->
                    genre.getBooks().add(bookConverter.convert(command)));
        }

        return genre;
    }
}
