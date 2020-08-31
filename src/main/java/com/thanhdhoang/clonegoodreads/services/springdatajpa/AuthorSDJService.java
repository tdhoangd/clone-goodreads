package com.thanhdhoang.clonegoodreads.services.springdatajpa;

import com.thanhdhoang.clonegoodreads.exception.NotFoundException;
import com.thanhdhoang.clonegoodreads.persistence.domain.Author;
import com.thanhdhoang.clonegoodreads.persistence.repositories.AuthorRepository;
import com.thanhdhoang.clonegoodreads.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.List;

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
        Optional<Author> optionalAuthor = authorRepository.findById(aLong);
        if (optionalAuthor.isEmpty())
            throw new NotFoundException("Author by id " + aLong + " not found");
        return optionalAuthor.get();
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

    @Override
    public Set<Author> findAllByNameLikeIgnoreCase(String name) {
        Set<Author> authors = new HashSet<>();
        authorRepository.findByNameLikeIgnoreCase(name).forEach(authors::add);
        return authors;
    }
}
