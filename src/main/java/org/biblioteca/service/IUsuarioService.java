package org.biblioteca.service;

import org.biblioteca.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> gettAllUsuarios();

    List<Usuario> getUsuarioByNombre(String nombre);

    Usuario saveUsuario(Usuario usuario);

    Usuario getUsuarioById(Long id);

    Usuario updateUsuario(Usuario usuario);

    void deleteUsuarioById(Long id);
}
