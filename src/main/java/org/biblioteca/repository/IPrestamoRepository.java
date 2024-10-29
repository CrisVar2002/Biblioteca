package org.biblioteca.repository;

import org.biblioteca.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPrestamoRepository extends JpaRepository<Prestamo, Long> {
    @Query("FROM Prestamo p WHERE p.fechaPrestamo LIKE %:fechaPrestamo%")
    List<Prestamo> findByFechaPrestamoContaining(@Param("fechaPrestamo") String fechaPrestamo);
}
