package com.thanhdhoang.clonegoodreads.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class BookCommand {
    private Long id;

    @NotBlank
    private String title;

    private String isbn;
    private String description;

    @URL
    private String coverImageUrl;

    private Set<ReviewCommand> reviews = new HashSet<>();
    private Set<GenreCommand> genres = new HashSet<>();
    private AuthorCommand author;
}
