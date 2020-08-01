package com.thanhdhoang.clonegoodreads.services.springdatajpa;

import com.thanhdhoang.clonegoodreads.domain.Author;
import com.thanhdhoang.clonegoodreads.repositories.AuthorRepository;
import com.thanhdhoang.clonegoodreads.services.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class AuthorSDJServiceTest {

    @Mock
    AuthorRepository authorRepository;

    @InjectMocks
    AuthorSDJService service;

    public static final String NAME = "David";
    Author returnAuthor;

    @BeforeEach
    void setUp() {
        returnAuthor = Author.builder().id(1L).name(NAME).build();
    }

//    @Test
//    void findAll() {
//        Set<Author> returnAuthorsSet = new HashSet<>();
//        returnAuthorsSet.add(Author.builder().id(1L).build());
//        returnAuthorsSet.add(Author.builder().id(2L).build());
//
//        when(authorRepository.findAll()).thenReturn(returnAuthorsSet);
//
//        Set<Author> authors = service.findAll();
//
////        assertNotNull(authors);
////        assertEquals(2, authors.size());
//    }

    @Test
    void findById() {
//        when(authorRepository.findById(anyLong())).thenReturn(Optional.of(returnAuthor));
//        Author author = service.findById(1L);
//        assertNotNull(author);
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}