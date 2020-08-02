package com.thanhdhoang.clonegoodreads.converters;

import com.thanhdhoang.clonegoodreads.commands.BookCommand;
import com.thanhdhoang.clonegoodreads.domain.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookCommand implements Converter<Book, BookCommand> {

    private final ReviewToReviewCommand reivewConverter;
    private final GenreToGenreCommand genreConverter;
    private final AuthorToAuthorCommand authorConverter;

    public BookToBookCommand(ReviewToReviewCommand reivewConverter,
                             GenreToGenreCommand genreConverter,
                             AuthorToAuthorCommand authorConverter) {
        this.reivewConverter = reivewConverter;
        this.genreConverter = genreConverter;
        this.authorConverter = authorConverter;
    }

    @Override
    public BookCommand convert(Book source) {
        if (source == null) {
            return null;
        }

        final BookCommand bookCommand = new BookCommand();

        bookCommand.setId(source.getId());
        bookCommand.setTitle(source.getTitle());
        bookCommand.setIsbn(source.getIsbn());
        bookCommand.setCoverImageUrl(source.getCoverImageUrl());
        bookCommand.setAuthor(authorConverter.convert(source.getAuthor()));

        if (source.getReviews() != null && source.getReviews().size() > 0) {
            source.getReviews().forEach(book ->
                    bookCommand.getReviews().add(reivewConverter.convert(book)));
        }

        if (source.getGenres() != null &&  source.getReviews().size() > 0) {
            source.getGenres().forEach(book ->
                    bookCommand.getGenres().add(genreConverter.convert(book)));
        }

        return bookCommand;
    }
}
