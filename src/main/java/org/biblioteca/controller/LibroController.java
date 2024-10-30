package org.biblioteca.controller;

import org.biblioteca.entity.Libro;
import org.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibroController {
    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/libros")
    public String getAllLibroes(Model model) {
        model.addAttribute("libros", libroService.getAllLibros());
        return "libros";
    }

    @GetMapping("/libros/new")
    public String createLibroForm(Model model){

        // este objeto Libro almacenara los valores
        Libro libro = new Libro();

        model.addAttribute("libro", libro);

        return "create_libro";
    }

    @PostMapping("/libros")
    public String saveLibro(@ModelAttribute("libro") Libro libro) {
        libroService.saveLibro(libro);
        return "redirect:/libros";
    }

    @GetMapping("/libros/edit/{id}")
    public String editLibroForm(@PathVariable Long id, Model model) {
        Libro st = libroService.getLibroById(id);

        model.addAttribute("libro", st);

        return "edit_libro";
    }

    @PostMapping("/libros/{id}")
    public String updateLibro(@PathVariable Long id,
                              @ModelAttribute("libro") Libro libro,
                              Model model) {
        //sacar el esudiante de la b.d. por el id
        Libro existentLibro = libroService.getLibroById(id);
        // cargarlo
        existentLibro.setId_libro(id);
        existentLibro.setTitulo(libro.getTitulo());
        existentLibro.setAnio_publicacion(libro.getAnio_publicacion());
        existentLibro.setGenero(libro.getGenero());

        // guardar el estudiante actualizado
        libroService.updateLibro(existentLibro);

        return "redirect:/libros";
    }

    @GetMapping("/libros/{id}")
    public String deleteLibro(@PathVariable Long id) {
        libroService.deleteLibroById(id);
        return "redirect:/libros";
    }
}
