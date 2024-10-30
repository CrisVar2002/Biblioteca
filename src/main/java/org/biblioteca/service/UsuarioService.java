package org.biblioteca.service;

import org.biblioteca.entity.Usuario;
import org.biblioteca.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    private final IUsuarioRepository usuarioRepository;


    @Autowired
    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> gettAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> getUsuarioByNombre(String nombre) {
        return usuarioRepository.findByNombreContaining(nombre);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);

    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuarioById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
