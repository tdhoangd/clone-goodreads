package com.thanhdhoang.clonegoodreads.persistence.repositories;

import com.thanhdhoang.clonegoodreads.persistence.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

//    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    User findByUsername(String username);
}
