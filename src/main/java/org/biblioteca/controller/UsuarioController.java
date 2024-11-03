package org.biblioteca.controller;

import org.biblioteca.entity.Usuario;
import org.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(savedUsuario);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario existentUsuario = usuarioService.getUsuarioById(id);
        if (existentUsuario == null) {
            return ResponseEntity.notFound().build();
        }
        existentUsuario.setNombre(usuario.getNombre());
        existentUsuario.setApellido(usuario.getApellido());
        existentUsuario.setEmail(usuario.getEmail());
        usuarioService.updateUsuario(existentUsuario);
        return ResponseEntity.ok(existentUsuario);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.deleteUsuarioById(id);
        return ResponseEntity.noContent().build();
    }
}