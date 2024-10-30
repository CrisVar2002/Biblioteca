package org.biblioteca.repository;

import org.biblioteca.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ILibroRepository extends JpaRepository<Libro, Long> {
    @Query("FROM Libro l WHERE l.titulo LIKE %:titulo%")
    List<Libro> findByTituloContaining(@Param("titulo") String titulo);
}
