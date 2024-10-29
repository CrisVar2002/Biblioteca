package org.biblioteca.service;

import org.biblioteca.entity.Prestamo;

import java.util.List;

public interface IPrestamoService {
    List<Prestamo> gettAllPrestamos();

    List<Prestamo> getPrestamoByNombre(String nombre);

    Prestamo savePrestamo(Prestamo prestamo);

    Prestamo getPrestamoById(Long id);

    Prestamo updatePrestamo(Prestamo prestamo);

    void deletePrestamoById(Long id);
}
