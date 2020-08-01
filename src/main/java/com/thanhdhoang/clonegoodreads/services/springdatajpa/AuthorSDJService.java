package com.thanhdhoang.clonegoodreads.services.springdatajpa;

import com.thanhdhoang.clonegoodreads.domain.Author;
import com.thanhdhoang.clonegoodreads.repositories.AuthorRepository;
import com.thanhdhoang.clonegoodreads.repositories.GenreRepository;
import com.thanhdhoang.clonegoodreads.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthorSDJService implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorSDJService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Set<Author> findAll() {
        Set<Author> authors = new HashSet<>();
        authorRepository.findAll().forEach(authors::add);
        return authors;
    }

    @Override
    public Author findById(Long aLong) {
        return authorRepository.findById(aLong).orElse(null);
    }

    @Override
    public Author save(Author object) {
        return authorRepository.save(object);
    }

    @Override
    public void delete(Author object) {
        authorRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        authorRepository.deleteById(aLong);
    }
}
