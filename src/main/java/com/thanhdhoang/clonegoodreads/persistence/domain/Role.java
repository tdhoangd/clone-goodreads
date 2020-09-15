package com.thanhdhoang.clonegoodreads.persistence.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Role extends BaseEntity {

    private String name;

}
