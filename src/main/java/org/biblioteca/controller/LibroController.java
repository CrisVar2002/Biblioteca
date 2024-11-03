package org.biblioteca.controller;

import org.biblioteca.entity.Libro;
import org.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibroController {
    private static final Logger logger = LoggerFactory.getLogger(LibroController.class);
    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping("/libro")
    public ResponseEntity<Libro> createLibro(@RequestBody Libro libro) {
        logger.info("Received request to create libro: {}", libro);
        Libro savedLibro = libroService.saveLibro(libro);
        return new ResponseEntity<>(savedLibro, HttpStatus.CREATED);
    }

    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> getAllLibros() {
        List<Libro> libros = libroService.getAllLibros();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/libro/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Libro libro = libroService.getLibroById(id);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro);
    }

    @PutMapping("/libro/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
        Libro existentLibro = libroService.getLibroById(id);
        if (existentLibro == null) {
            return ResponseEntity.notFound().build();
        }
        existentLibro.setTitulo(libro.getTitulo());
        existentLibro.setAnio_publicacion(libro.getAnio_publicacion());
        existentLibro.setGenero(libro.getGenero());
        libroService.updateLibro(existentLibro);
        return ResponseEntity.ok(existentLibro);
    }

    @DeleteMapping("/libro/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        Libro libro = libroService.getLibroById(id);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        libroService.deleteLibroById(id);
        return ResponseEntity.noContent().build();
    }
}