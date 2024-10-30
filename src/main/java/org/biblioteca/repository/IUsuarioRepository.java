package org.biblioteca.repository;

import org.biblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query ("FROM Usuario u WHERE u.nombre LIKE %:nombre%")
    List<Usuario> findByNombreContaining(@Param("nombre") String nombre);
}
