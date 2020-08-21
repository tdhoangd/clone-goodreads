package com.thanhdhoang.clonegoodreads.persistence.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
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
        if (genres == null || genres.size() > 0) {
            this.genres = genres;
        }
    }

    @NotNull
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String birthPlace;

    @Column(columnDefinition = "TEXT")
    private String bio;
    private String website;
    private String twitter;
    private String imageUrl;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "author_genre",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id",
                    nullable = false),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id",
                    nullable = false))
    private Set<Genre> genres = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
    private Set<Book> books = new HashSet<>();
}
