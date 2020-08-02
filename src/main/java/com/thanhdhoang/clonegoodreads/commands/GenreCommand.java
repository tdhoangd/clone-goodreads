package com.thanhdhoang.clonegoodreads.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class GenreCommand {
    private Long id;

    @NotBlank
    private String genre;

    private Set<AuthorCommand> authors = new HashSet<>();
    private Set<BookCommand> books = new HashSet<>();
}
