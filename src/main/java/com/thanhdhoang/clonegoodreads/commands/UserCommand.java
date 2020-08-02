package com.thanhdhoang.clonegoodreads.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserCommand {
    private Long id;

    @NotBlank
    private String username;
    private String sessionToken;

    @NotBlank
    private String password;
    private String firstName;
    private String lastName;

    @Email
    private String email;
    private Set<ReviewCommand> reviews = new HashSet<>();
}
