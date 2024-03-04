package com.dev.harem.repository;

import com.dev.harem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
