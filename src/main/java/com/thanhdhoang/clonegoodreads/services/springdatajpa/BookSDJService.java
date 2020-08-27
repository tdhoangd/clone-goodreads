package com.thanhdhoang.clonegoodreads.services.springdatajpa;

import com.thanhdhoang.clonegoodreads.persistence.domain.Book;
import com.thanhdhoang.clonegoodreads.persistence.repositories.BookRepository;
import com.thanhdhoang.clonegoodreads.persistence.repositories.GenreRepository;
import com.thanhdhoang.clonegoodreads.persistence.repositories.ReviewRepository;
import com.thanhdhoang.clonegoodreads.services.BookService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookSDJService implements BookService {

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final ReviewRepository reviewRepository;

    public BookSDJService(BookRepository bookRepository,
                          GenreRepository genreRepository,
                          ReviewRepository reviewRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Set<Book> findAll() {
        Set<Book> books = new HashSet<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Book findById(Long aLong) {
        return bookRepository.findById(aLong).orElse(null);
    }

    @Override
    public Book save(Book object) {
        return bookRepository.save(object);
    }

    @Override
    public void delete(Book object) {
        bookRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        bookRepository.deleteById(aLong);
    }
}
