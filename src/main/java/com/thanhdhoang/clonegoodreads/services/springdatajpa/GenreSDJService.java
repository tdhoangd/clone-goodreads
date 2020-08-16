package com.thanhdhoang.clonegoodreads.services.springdatajpa;

import com.thanhdhoang.clonegoodreads.persistence.model.Genre;
import com.thanhdhoang.clonegoodreads.persistence.repositories.GenreRepository;
import com.thanhdhoang.clonegoodreads.services.GenreService;
import com.thanhdhoang.clonegoodreads.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

import java.util.Optional;
import java.util.Set;


@Service
public class GenreSDJService implements GenreService {

    private final GenreRepository genreRepository;

    public GenreSDJService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Set<Genre> findAll() {
        Set<Genre> genres = new HashSet<>();
        genreRepository.findAll().forEach(genres::add);
        return genres;
    }

    @Override
    public Genre findById(Long aLong) {
        return genreRepository.findById(aLong).orElse(null);
    }

    @Override
    public Genre save(Genre object) {
        return genreRepository.save(object);
    }

    @Override
    public void delete(Genre object) {
        genreRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        genreRepository.deleteById(aLong);
    }

    @Override
    public Genre findByName(String name) {
        Optional<Genre> optionalGenre = genreRepository.findByNameIgnoreCase(name);

        if (!optionalGenre.isPresent()) {
            throw new NotFoundException("Genre not found. Genre: " + name);
        }

        return optionalGenre.get();
    }
}
