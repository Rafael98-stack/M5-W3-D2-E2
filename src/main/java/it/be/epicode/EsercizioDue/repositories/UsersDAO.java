package it.be.epicode.EsercizioDue.repositories;

import it.be.epicode.EsercizioDue.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersDAO extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email); // alternativa egualmente valida al findByEmail
}
