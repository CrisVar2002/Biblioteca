package org.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "libro", schema = "biblioteca", catalog = "postgres")
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

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;
}