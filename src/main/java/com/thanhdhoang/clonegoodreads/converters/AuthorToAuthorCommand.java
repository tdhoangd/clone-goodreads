package com.thanhdhoang.clonegoodreads.converters;

import com.thanhdhoang.clonegoodreads.commands.AuthorCommand;
import com.thanhdhoang.clonegoodreads.domain.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorToAuthorCommand implements Converter<Author, AuthorCommand> {

    private final GenreToGenreCommand genreConverter;

    public AuthorToAuthorCommand(GenreToGenreCommand genreConverter) {
        this.genreConverter = genreConverter;

    }

    @Override
    public AuthorCommand convert(Author source) {
        if (source == null){
            return null;
        }

        final AuthorCommand authorCommand = new AuthorCommand();

        authorCommand.setId(source.getId());
        authorCommand.setName(source.getName());
        authorCommand.setGender(source.getGender());
        authorCommand.setBirthday(source.getBirthday());
        authorCommand.setBio(source.getBio());
        authorCommand.setWebsite(source.getWebsite());
        authorCommand.setUrlImage(source.getUrlImage());

        if (source.getGenres() != null && source.getGenres().size() > 0) {
            source.getGenres().forEach(command ->
                    authorCommand.getGenres().add(genreConverter.convert(command)));
        }

        return authorCommand;
    }
}
