package com.thanhdhoang.clonegoodreads.persistence.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    @Column(unique = true)
    private String username;
//    private String sessionToken;
    private String password;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "user", orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();
}
