package org.biblioteca.controller;

import org.biblioteca.entity.Autor;
import org.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AutorController {
    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/autores")
    public ResponseEntity<List<Autor>> getAllAutores() {
        // Obtener todos los autores
        List<Autor> autores = autorService.gettAllAutors();
        return ResponseEntity.ok(autores);
    }

    @PostMapping("/autor")
    public ResponseEntity<Autor> saveAutor(@RequestBody Autor autor) {
        // Guardar un nuevo autor
        Autor savedAutor = autorService.saveAutor(autor);
        return ResponseEntity.ok(savedAutor);
    }

    @PutMapping("/autor/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Long id, @RequestBody Autor autor) {
        // Actualizar un autor existente
        Autor existentAutor = autorService.getAutorById(id);
        if (existentAutor == null) {
            return ResponseEntity.notFound().build();
        }
        existentAutor.setNombre(autor.getNombre());
        existentAutor.setApellido(autor.getApellido());
        existentAutor.setFecha_nacimiento(autor.getFecha_nacimiento());
        autorService.updateAutor(existentAutor);
        return ResponseEntity.ok(existentAutor);
    }

    @DeleteMapping("/autor/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        // Eliminar un autor por ID
        Autor autor = autorService.getAutorById(id);
        if (autor == null) {
            return ResponseEntity.notFound().build();
        }
        autorService.deleteAutorById(id);
        return ResponseEntity.noContent().build();
    }
}