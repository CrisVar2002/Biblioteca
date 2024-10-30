package org.biblioteca.controller;

import org.biblioteca.entity.Usuario;
import org.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("usuario", usuarioService.gettAllUsuarios());
        return "usuario";
    }

    @GetMapping("/usuario")
    public String getAllUsuarioes(Model model) {
        model.addAttribute("usuario", usuarioService.gettAllUsuarios());
        return "usuario";
    }

    @GetMapping("/usuario/new")
    public String createUsuarioForm(Model model){

        // este objeto Usuario almacenara los valores
        Usuario usuario = new Usuario();

        model.addAttribute("usuario", usuario);

        return "create_usuario";
    }

    @PostMapping("/usuario")
    public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/usuario/edit/{id}")
    public String editUsuarioForm(@PathVariable Long id, Model model) {
        Usuario st = usuarioService.getUsuarioById(id);

        model.addAttribute("usuario", st);

        return "edit_usuario";
    }

    @PostMapping("/usuario/{id}")
    public String updateUsuario(@PathVariable Long id,
                              @ModelAttribute("usuario") Usuario usuario,
                              Model model) {
        //sacar el esudiante de la b.d. por el id
        Usuario existentUsuario = usuarioService.getUsuarioById(id);
        // cargarlo
        existentUsuario.setId_usuario(id);
        existentUsuario.setNombre(usuario.getNombre());
        existentUsuario.setApellido(usuario.getApellido());
        existentUsuario.setEmail(usuario.getEmail());

        // guardar el estudiante actualizado
        usuarioService.updateUsuario(existentUsuario);

        return "redirect:/usuario";
    }

    @GetMapping("/usuario/{id}")
    public String deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuarioById(id);
        return "redirect:/usuario";
    }
}
