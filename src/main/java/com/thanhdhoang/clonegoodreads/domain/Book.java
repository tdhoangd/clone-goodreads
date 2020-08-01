package com.thanhdhoang.clonegoodreads.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book extends BaseEntity {

    private String title;
    private String isbn;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String coverImageUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Set<Review> reviews = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id",
                    nullable = false),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id",
                    nullable = false))
    private Set<Genre> genres = new HashSet<>();

    @ManyToOne
    private Author author;
}
