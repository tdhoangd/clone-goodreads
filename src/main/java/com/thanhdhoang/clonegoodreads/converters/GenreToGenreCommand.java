package com.thanhdhoang.clonegoodreads.converters;

import com.thanhdhoang.clonegoodreads.commands.GenreCommand;
import com.thanhdhoang.clonegoodreads.domain.Genre;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GenreToGenreCommand implements Converter<Genre, GenreCommand> {

    private final AuthorToAuthorCommand authorConverter;
    private final BookToBookCommand bookConverter;

    public GenreToGenreCommand(AuthorToAuthorCommand authorConverter,
                               BookToBookCommand bookConverter) {
        this.authorConverter = authorConverter;
        this.bookConverter = bookConverter;
    }

    @Override
    public GenreCommand convert(Genre source) {
        if (source == null) {
            return null;
        }

        final GenreCommand genreCommand = new GenreCommand();
        genreCommand.setId(source.getId());
        genreCommand.setGenre(source.getGenre());

        if (source.getAuthors() != null && source.getAuthors().size() > 0) {
            source.getAuthors().forEach(genre ->
                    genreCommand.getAuthors().add(authorConverter.convert(genre)));
        }
        if (source.getBooks() != null && source.getBooks().size() > 0) {
            source.getBooks().forEach(genre ->
                    genreCommand.getBooks().add(bookConverter.convert(genre)));
        }

        return genreCommand;
    }
}
