package org.biblioteca.service;

import org.biblioteca.entity.Prestamo;
import org.biblioteca.repository.IPrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService implements IPrestamoService {
    private final IPrestamoRepository prestamoRepository;

    @Autowired
    public PrestamoService(IPrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    public List<Prestamo> gettAllPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo savePrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo getPrestamoById(Long id) {
        return prestamoRepository.findById(id).orElse(null);
    }

    @Override
    public Prestamo updatePrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public void deletePrestamoById(Long id) {
        prestamoRepository.deleteById(id);
    }
}
