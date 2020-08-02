package com.thanhdhoang.clonegoodreads.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.validator.constraints.NotBlank;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class AuthorCommand {
    private Long id;

    @NotBlank
    private String name;

    private String gender;
    private Date birthday;
    private String bio;

    @URL
    private String website;

    @URL
    private String urlImage;

    private Set<GenreCommand> genres = new HashSet<>();
    private Set<BookCommand> books = new HashSet<>();
}
