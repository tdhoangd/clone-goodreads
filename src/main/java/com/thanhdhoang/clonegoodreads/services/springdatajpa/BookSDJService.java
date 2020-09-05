package com.thanhdhoang.clonegoodreads.services.springdatajpa;

import com.thanhdhoang.clonegoodreads.exception.NotFoundException;
import com.thanhdhoang.clonegoodreads.persistence.domain.Book;
import com.thanhdhoang.clonegoodreads.persistence.repositories.BookRepository;
import com.thanhdhoang.clonegoodreads.persistence.repositories.GenreRepository;
import com.thanhdhoang.clonegoodreads.persistence.repositories.ReviewRepository;
import com.thanhdhoang.clonegoodreads.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
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
        Optional<Book> optionalBook = bookRepository.findById(aLong);
        if (optionalBook.isEmpty())
            throw new NotFoundException("Book by id " + aLong + " not found");
        return optionalBook.get();
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

    @Override
    public Page<Book> findByKeyword(String q, Pageable pageable) {
        // q can be title or isbn
//        Set<Book> books = new HashSet<>();
//        bookRepository.findByTitleLikeIgnoreCaseOrIsbnLike(q, q).forEach(books::add);
        return bookRepository.findByTitleLikeIgnoreCaseOrIsbnLike(q, q, pageable);
    }
}
