package org.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "libro")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_libro;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "anio_publicacion", nullable = false)
    private int anio_publicacion;
    @Column(name = "genero", nullable = false)
    private String genero;
}
