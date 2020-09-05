package com.thanhdhoang.clonegoodreads.persistence.domain;

import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author extends BaseEntity {

    @Builder
    public Author(Long id, String name, Date birthday, String birthPlace, String bio,
                  String website, String twitter, String imageUrl, Set<Genre> genres) {
        super(id);
        this.name = name;
        this.birthday = birthday;
        this.birthPlace = birthPlace;
        this.bio = bio;
        this.website = website;
        this.twitter = twitter;
        this.imageUrl = imageUrl;
        if (genres != null) {
            this.genres = genres;
        }
    }

    @NotNull
    @Column(nullable = false)
    @NotEmpty(message = "Name may not be empty")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String birthPlace;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @URL
    private String website;
    private String twitter;

    @URL
    private String imageUrl;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinTable(name = "author_genre",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id",
                    nullable = false),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id",
                    nullable = false))
    private Set<Genre> genres = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "author",
            orphanRemoval = true)
    private Set<Book> books = new HashSet<>();
}
