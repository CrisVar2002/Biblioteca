package org.biblioteca.service;

import org.biblioteca.entity.Prestamo;
import org.biblioteca.repository.IPrestamoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService implements IPrestamoService{
    private final IPrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> gettAllPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public List<Prestamo> getPrestamoByNombre(String nombre) {
        return List.of();
    }

    @Override
    public Prestamo savePrestamo(Prestamo prestamo) {
        return null;
    }

    @Override
    public Prestamo getPrestamoById(Long id) {
        return null;
    }

    @Override
    public Prestamo updatePrestamo(Prestamo prestamo) {
        return null;
    }

    @Override
    public void deletePrestamoById(Long id) {

    }
}
