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
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("usuarios", usuarioService.gettAllUsuarios());
        return "usuario";
    }

    @GetMapping("/usuarios")
    public String getAllUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.gettAllUsuarios());
        return "usuario";
    }

    @GetMapping("/usuario/new")
    public String createUsuarioForm(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "create_usuario";
    }

    @PostMapping("/usuario")
    public RedirectView saveUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return new RedirectView("/usuarios");
    }

    @GetMapping("/usuario/edit/{id}")
    public String editUsuarioForm(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        return "edit_usuario";
    }

    @PostMapping("/usuario/{id}")
    public RedirectView updateUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario) {
        Usuario existentUsuario = usuarioService.getUsuarioById(id);
        existentUsuario.setId_usuario(id);
        existentUsuario.setNombre(usuario.getNombre());
        existentUsuario.setApellido(usuario.getApellido());
        existentUsuario.setEmail(usuario.getEmail());
        usuarioService.updateUsuario(existentUsuario);
        return new RedirectView("/usuarios");
    }

    @GetMapping("/usuario/delete/{id}")
    public RedirectView deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuarioById(id);
        return new RedirectView("/usuarios");
    }
}