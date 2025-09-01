package com.graphql.project.Graphql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Long>{

    Optional<AppUser> findByUsername(String username);

}
