package com.thanhdhoang.clonegoodreads.converters;

import com.thanhdhoang.clonegoodreads.commands.BookCommand;
import com.thanhdhoang.clonegoodreads.persistence.model.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookCommandToBook implements Converter<BookCommand, Book> {

    private final GenreCommandToGenre genreConverter;
    private final ReviewCommandToReview reviewConverter;
    private final AuthorCommandToAuthor authorConverter;

    public BookCommandToBook(GenreCommandToGenre genreConverter,
                             ReviewCommandToReview reviewConverter,
                             AuthorCommandToAuthor authorConverter) {
        this.genreConverter = genreConverter;
        this.reviewConverter = reviewConverter;
        this.authorConverter = authorConverter;
    }

    @Override
    public Book convert(BookCommand source) {
        if (source == null) {
            return null;
        }

        final Book book = new Book();

        book.setId(source.getId());
        book.setTitle(source.getTitle());
        book.setIsbn(source.getIsbn());
        book.setCoverImageUrl(source.getCoverImageUrl());
        book.setAuthor(authorConverter.convert(source.getAuthor()));

        if (source.getReviews() != null && source.getReviews().size() > 0) {
            source.getReviews().forEach(command ->
                    book.getReviews().add(reviewConverter.convert(command)));
        }

        if (source.getGenres() != null &&  source.getReviews().size() > 0) {
            source.getGenres().forEach(command ->
                    book.getGenres().add(genreConverter.convert(command)));
        }

        return book;
    }


}
