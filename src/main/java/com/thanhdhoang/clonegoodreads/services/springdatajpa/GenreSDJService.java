package com.thanhdhoang.clonegoodreads.services.springdatajpa;

import com.thanhdhoang.clonegoodreads.commands.GenreCommand;
import com.thanhdhoang.clonegoodreads.converters.GenreToGenreCommand;
import com.thanhdhoang.clonegoodreads.persistence.model.Genre;
import com.thanhdhoang.clonegoodreads.persistence.repositories.GenreRepository;
import com.thanhdhoang.clonegoodreads.services.GenreService;
import com.thanhdhoang.clonegoodreads.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GenreSDJService implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreToGenreCommand genreToGenreCommand;

    public GenreSDJService(GenreRepository genreRepository, GenreToGenreCommand genreToGenreCommand) {
        this.genreRepository = genreRepository;
        this.genreToGenreCommand = genreToGenreCommand;
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
    public Set<GenreCommand> listAllGenres() {
        return StreamSupport.stream(findAll().spliterator(), false)
                .map(genreToGenreCommand::convert)
                .collect(Collectors.toSet());
    }

    @Override
    public Genre findByName(String name) {
        Optional<Genre> genreOptional = genreRepository.findByName(name);

        if (!genreOptional.isPresent()) {
            throw new NotFoundException("Genre Not Found. For genre value: " + name.toString() );
        }

        return genreOptional.get();
    }

    @Override
    @Transactional
    public GenreCommand findCommandByName(String name) {
        return genreToGenreCommand.convert(findByName(name));
    }
}
