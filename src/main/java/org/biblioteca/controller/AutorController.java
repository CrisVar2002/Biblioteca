package org.biblioteca.controller;

import org.biblioteca.entity.Autor;
import org.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutorController {
    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/autores")
    public String getAllAutores(Model model) {
        model.addAttribute("autores", autorService.gettAllAutors());
        return "autores";
    }

    @GetMapping("/autores/new")
    public String createAutorForm(Model model){

        // este objeto Autor almacenara los valores
        Autor autor = new Autor();

        model.addAttribute("autor", autor);

        return "create_autor";
    }

    @PostMapping("/autores")
    public String saveAutor(@ModelAttribute("autor") Autor autor) {
        autorService.saveAutor(autor);
        return "redirect:/autores";
    }

    @GetMapping("/autores/edit/{id}")
    public String editAutorForm(@PathVariable Long id, Model model) {
        Autor st = autorService.getAutorById(id);

        model.addAttribute("autor", st);

        return "edit_autor";
    }

    @PostMapping("/autores/{id}")
    public String updateAutor(@PathVariable Long id,
                              @ModelAttribute("autor") Autor autor,
                              Model model) {
        //sacar el esudiante de la b.d. por el id
        Autor existentAutor = autorService.getAutorById(id);
        // cargarlo
        existentAutor.setId_autor(id);
        existentAutor.setNombre(autor.getNombre());
        existentAutor.setApellido(autor.getApellido());
        existentAutor.setFecha_nacimiento(autor.getFecha_nacimiento());

        // guardar el estudiante actualizado
        autorService.updateAutor(existentAutor);

        return "redirect:/autores";
    }

    @GetMapping("/autores/{id}")
    public String deleteAutor(@PathVariable Long id) {
        autorService.deleteAutorById(id);
        return "redirect:/autores";
    }
}