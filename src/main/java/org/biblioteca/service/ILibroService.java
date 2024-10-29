package org.biblioteca.service;

import org.biblioteca.entity.Libro;

import java.util.List;

public interface ILibroService {

    List<Libro> getAllLibros();

    List<Libro> getLibroByNombre(String nombre);

    Libro saveLibro(Libro libro);

    Libro getLibroById(Long id);

    Libro updateLibro(Libro libro);

    void deleteLibroById(Long id);
}
