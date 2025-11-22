package com.facilitur.api.repository;

import com.facilitur.api.models.entities.UsuarioNewsletter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioNewsletterRepository extends JpaRepository<UsuarioNewsletter, Long> {
    Optional<UsuarioNewsletter> findByEmail(String email);
    List<UsuarioNewsletter> findByAtivoTrue();
}
