package org.biblioteca.controller;

import org.biblioteca.entity.Prestamo;
import org.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PrestamoController {
    private final PrestamoService prestamoService;

    @Autowired
    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping("/prestamos")
    public String getAllPrestamos(Model model) {
        model.addAttribute("prestamos", prestamoService.gettAllPrestamos());
        return "prestamos";
    }

    @GetMapping("/prestamos/new")
    public String createPrestamoForm(Model model) {
        Prestamo prestamo = new Prestamo();
        model.addAttribute("prestamo", prestamo);
        return "create_prestamo";
    }

    @PostMapping("/prestamos")
    public RedirectView savePrestamo(@ModelAttribute("prestamo") Prestamo prestamo) {
        prestamoService.savePrestamo(prestamo);
        return new RedirectView("/prestamos");
    }

    @GetMapping("/prestamos/edit/{id}")
    public String editPrestamoForm(@PathVariable Long id, Model model) {
        Prestamo prestamo = prestamoService.getPrestamoById(id);
        model.addAttribute("prestamo", prestamo);
        return "edit_prestamo";
    }

    @PostMapping("/prestamos/{id}")
    public RedirectView updatePrestamo(@PathVariable Long id, @ModelAttribute("prestamo") Prestamo prestamo) {
        Prestamo existentPrestamo = prestamoService.getPrestamoById(id);
        existentPrestamo.setId_prestamo(id);
        existentPrestamo.setFecha_prestamo(prestamo.getFecha_prestamo());
        existentPrestamo.setFecha_devolucion(prestamo.getFecha_devolucion());
        existentPrestamo.setUsuario(prestamo.getUsuario());
        existentPrestamo.setLibro(prestamo.getLibro());
        prestamoService.updatePrestamo(existentPrestamo);
        return new RedirectView("/prestamos");
    }

    @GetMapping("/prestamos/delete/{id}")
    public RedirectView deletePrestamo(@PathVariable Long id) {
        prestamoService.deletePrestamoById(id);
        return new RedirectView("/prestamos");
    }
}
