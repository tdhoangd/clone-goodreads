package com.thanhdhoang.clonegoodreads.repositories;

import com.thanhdhoang.clonegoodreads.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {


}
