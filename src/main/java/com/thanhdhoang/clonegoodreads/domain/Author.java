package com.thanhdhoang.clonegoodreads.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
    public Author(Long id, String name, String gender, Date birthday,
                  String bio, String website, String urlImage,
                  Set<Genre> genres) {
        super(id);
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.bio = bio;
        this.website = website;
        this.urlImage = urlImage;
        if (genres == null || genres.size() > 0) {
            this.genres = genres;
        }
    }

    private String name;
    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column(columnDefinition = "TEXT")
    private String bio;
    private String website;
    private String urlImage;

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
