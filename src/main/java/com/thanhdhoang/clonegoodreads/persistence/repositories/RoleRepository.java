package com.thanhdhoang.clonegoodreads.persistence.repositories;

import com.thanhdhoang.clonegoodreads.persistence.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
