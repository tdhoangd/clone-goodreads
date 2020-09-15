package com.thanhdhoang.clonegoodreads.services;

import com.thanhdhoang.clonegoodreads.persistence.domain.User;

public interface UserService extends CrudService<User, Long> {

    User findByEmail(String email);
    User findByUsername(String username);
}
