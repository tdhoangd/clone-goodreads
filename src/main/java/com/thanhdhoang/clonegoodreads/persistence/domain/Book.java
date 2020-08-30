package com.thanhdhoang.clonegoodreads.persistence.domain;




import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book extends BaseEntity {

    @Builder
    public Book(Long id, String title, String isbn, String description, String imageUrl,
                Set<Review> reviews, Set<Genre> genres, Author author) {
        super(id);
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.imageUrl = imageUrl;
        if (reviews != null) {
            this.reviews = reviews;
        }

        if (genres != null) {
            this.genres = genres;
        }
    }


    @NotNull
    @NotEmpty(message = "Title may not be empty")
    private String title;
    private String isbn;

    @Column(columnDefinition = "TEXT")
    private String description;

    @URL
    private String imageUrl;

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
