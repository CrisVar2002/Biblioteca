package org.biblioteca.service;

import lombok.Getter;
import lombok.Setter;
import org.biblioteca.entity.Autor;
import org.biblioteca.repository.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class AutorService implements IAutorService {
    private final IAutorRepository autorRepository;

    @Autowired
    public AutorService(IAutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> gettAllAutors() {
        return autorRepository.findAllOrderedById();
    }

    @Override
    public Autor saveAutor(Autor autor) {
        // Guardar un nuevo autor en el repositorio
        return autorRepository.save(autor);
    }

    @Override
    public Autor getAutorById(Long id) {
        // Obtener un autor por ID del repositorio
        return autorRepository.findById(id).orElse(null);
    }

    @Override
    public Autor updateAutor(Autor autor) {
        // Actualizar un autor existente en el repositorio
        return autorRepository.save(autor);
    }

    @Override
    public void deleteAutorById(Long id) {
        // Eliminar un autor por ID del repositorio
        autorRepository.deleteById(id);
    }
}