package com.thanhdhoang.clonegoodreads.converters;

import com.thanhdhoang.clonegoodreads.commands.AuthorCommand;
import com.thanhdhoang.clonegoodreads.domain.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorCommandToAuthor implements Converter<AuthorCommand, Author> {

    private final GenreCommandToGenre genreConverter;

    public AuthorCommandToAuthor(GenreCommandToGenre genreConverter) {
        this.genreConverter = genreConverter;

    }

    @Override
    public Author convert(AuthorCommand source) {
        if (source == null) {
            return null;
        }

        final Author author = new Author();

        author.setId(source.getId());
        author.setName(source.getName());
        author.setGender(source.getGender());
        author.setBirthday(source.getBirthday());
        author.setBio(source.getBio());
        author.setWebsite(source.getWebsite());
        author.setUrlImage(source.getUrlImage());

        if (source.getGenres() != null && source.getGenres().size() > 0) {
            source.getGenres().forEach(command ->
                    author.getGenres().add(genreConverter.convert(command)));
        }

        return author;
    }
}
