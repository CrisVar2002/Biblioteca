package org.biblioteca.service;

import org.biblioteca.entity.Autor;
import org.biblioteca.repository.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AutorService implements IAutorService {
    private final IAutorRepository autorRepository;

    @Autowired
    public AutorService(IAutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> gettAllAutors() {
        return autorRepository.findAll();
    }

    @Override
    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor getAutorById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    @Override
    public Autor updateAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void deleteAutorById(Long id) {

    }
}
