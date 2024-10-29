package org.biblioteca.service;

import org.biblioteca.entity.Autor;

import java.util.List;

public interface IAutorService {
    List<Autor> gettAllAutors();

    List<Autor> getAutorByNombre(String nombre);

    Autor saveAutor(Autor autor);

    Autor getAutorById(Long id);

    Autor updateAutor(Autor autor);

    void deleteAutorById(Long id);
}
