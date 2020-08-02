package com.thanhdhoang.clonegoodreads.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Genre extends BaseEntity {

    private String genre;

    @ManyToMany(mappedBy = "genres",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(mappedBy = "genres",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<>();
}
