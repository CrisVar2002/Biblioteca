package org.biblioteca.service;

import org.biblioteca.entity.Autor;

import java.util.List;

public interface IAutorService {
    // Método para obtener todos los autores
    List<Autor> gettAllAutors();

    // Método para guardar un nuevo autor
    Autor saveAutor(Autor autor);

    // Método para obtener un autor por ID
    Autor getAutorById(Long id);

    // Método para actualizar un autor existente
    Autor updateAutor(Autor autor);

    // Método para eliminar un autor por ID
    void deleteAutorById(Long id);
}