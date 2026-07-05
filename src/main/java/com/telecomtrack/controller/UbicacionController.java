package com.telecomtrack.controller;

import com.telecomtrack.domain.Ubicacion;
import com.telecomtrack.service.UbicacionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ubicacion")
public class UbicacionController {

    private final UbicacionService ubicacionService;

    public UbicacionController(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {

        var ubicaciones = ubicacionService.getUbicaciones();

        model.addAttribute("ubicaciones", ubicaciones);

        return "ubicacion/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute("ubicacion", new Ubicacion());

        return "ubicacion/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(
            @Valid Ubicacion ubicacion,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "ubicacion/modifica";
        }

        ubicacionService.save(ubicacion);

        return "redirect:/ubicacion/listado";
    }

    @GetMapping("/modificar/{idUbicacion}")
    public String modificar(
            @PathVariable Integer idUbicacion,
            Model model) {

        var ubicacion = new Ubicacion();
        ubicacion.setIdUbicacion(idUbicacion);

        ubicacion = ubicacionService.getUbicacion(ubicacion);

        model.addAttribute("ubicacion", ubicacion);

        return "ubicacion/modifica";
    }

    @GetMapping("/consultar/{idUbicacion}")
    public String consultar(
            @PathVariable Integer idUbicacion,
            Model model) {

        var ubicacion = new Ubicacion();
        ubicacion.setIdUbicacion(idUbicacion);

        ubicacion = ubicacionService.getUbicacion(ubicacion);

        model.addAttribute("ubicacion", ubicacion);

        return "ubicacion/consulta";
    }
}