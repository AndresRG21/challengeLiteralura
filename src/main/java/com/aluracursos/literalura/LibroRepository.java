package com.aluracursos.literalura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTituloContainsIgnoreCase(String titulo);

    @Query("SELECT e FROM Libro l JOIN l.libro l WHERE l.titulo ILIKE %:nombreLibro")
    List<Libro> librosPorNombre(String titulo);
}
