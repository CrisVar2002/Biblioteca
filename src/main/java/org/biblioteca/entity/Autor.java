package org.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Esta clase representa la entidad Autor, que está mapeada a la tabla "autor" en el esquema "biblioteca" y el catálogo "postgres".
 * Incluye campos para id_autor, nombre, apellido y fecha_nacimiento.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "autor", schema = "biblioteca", catalog = "postgres")
public class Autor {
    /**
     * Identificador único del autor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_autor;

    /**
     * Nombre del autor.
     */
    @Column(name = "nombre", nullable = false)
    private String nombre;

    /**
     * Apellido del autor.
     */
    @Column(name = "apellido", nullable = false)
    private String apellido;

    /**
     * Fecha de nacimiento del autor.
     */
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fecha_nacimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Libro> libros;
}