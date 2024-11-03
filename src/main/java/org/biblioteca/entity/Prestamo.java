package org.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id_libro", "id_usuario"})
@Entity
@Table(name = "prestamo", schema = "biblioteca", catalog = "postgres")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prestamo;
    @Column(name = "fecha_prestamo", nullable = false)
    private Date fecha_prestamo;
    @Column(name = "fecha_devolucion", nullable = false)
    private Date fecha_devolucion;

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
