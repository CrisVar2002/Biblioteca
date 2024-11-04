package org.biblioteca.service;

import org.biblioteca.entity.Libro;
import org.biblioteca.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService implements ILibroService {
    private final ILibroRepository libroRepository;

    @Autowired
    public LibroService(ILibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> getAllLibros() {
        return libroRepository.findAll().stream()
                .sorted((libro1, libro2) -> libro1.getId_libro().compareTo(libro2.getId_libro()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Libro> getLibroByNombre(String nombre) {
        return libroRepository.findByTituloContaining(nombre);
    }

    @Override
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro getLibroById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public Libro updateLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void deleteLibroById(Long id) {
        libroRepository.deleteById(id);
    }
}