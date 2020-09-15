package com.thanhdhoang.clonegoodreads.persistence.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    @Column(unique = true)
    @Length(min = 5, message = "User name must have at least 5 characters")
    @NotEmpty(message = "Username is required")
    private String username;

    @Length(min = 5, message = "Password must have at least 5 characters")
    @NotEmpty(message = "Password is required")
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable =
                    false),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id",
                    nullable = false)
    )
    private Set<Role> roles;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    @Email(message = "Please provide a valid email")
    @NotEmpty(message = "Email is required.")
    private String email;

    @Column(columnDefinition = "boolean default true")
    private boolean active;

    @Column(columnDefinition = "boolean default false")
    private boolean accountExpired;

    @Column(columnDefinition = "boolean default false")
    private boolean accountLocked;

    @Column(columnDefinition = "boolean default false")
    private boolean credentialsExpired;

//    @OneToMany(mappedBy = "user")
//    private Set<Review> reviews = new HashSet<>();

}
