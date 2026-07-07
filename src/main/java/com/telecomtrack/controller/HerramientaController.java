package com.telecomtrack.controller;

import com.telecomtrack.domain.Herramienta;
import com.telecomtrack.service.HerramientaService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/herramienta")
public class HerramientaController {

    private final HerramientaService herramientaService;

    public HerramientaController(HerramientaService herramientaService) {
        this.herramientaService = herramientaService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {

        var herramientas = herramientaService.getHerramientas();

        model.addAttribute("herramientas", herramientas);

        return "herramienta/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute("herramienta", new Herramienta());

        return "herramienta/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(
            @Valid Herramienta herramienta,
            BindingResult bindingResult) {

        var duplicado = herramienta.getIdHerramienta() == null
                ? herramientaService.existeCodigo(herramienta.getCodigo())
                : herramientaService.existeCodigoEnOtra(
                        herramienta.getCodigo(), herramienta.getIdHerramienta());

        if (duplicado) {
            bindingResult.rejectValue(
                    "codigo",
                    "validacion.herramienta.codigo.duplicado",
                    "El código ya está en uso");
        }

        if (bindingResult.hasErrors()) {
            return "herramienta/modifica";
        }

        if (herramienta.getIdHerramienta() == null) {

            herramientaService.save(herramienta);

            return "redirect:/herramienta/listado";
        }

        var existente = herramientaService.getHerramienta(herramienta.getIdHerramienta());

        if (existente.isEmpty()) {
            return "redirect:/herramienta/listado";
        }

        var actual = existente.get();

        actual.setCodigo(herramienta.getCodigo());
        actual.setNombre(herramienta.getNombre());
        actual.setDescripcion(herramienta.getDescripcion());

        herramientaService.save(actual);

        return "redirect:/herramienta/listado";
    }

    @GetMapping("/modificar/{idHerramienta}")
    public String modificar(
            @PathVariable Integer idHerramienta,
            Model model) {

        var herramienta = herramientaService.getHerramienta(idHerramienta);

        if (herramienta.isEmpty()) {
            return "redirect:/herramienta/listado";
        }

        model.addAttribute("herramienta", herramienta.get());

        return "herramienta/modifica";
    }

    @GetMapping("/consultar/{idHerramienta}")
    public String consultar(
            @PathVariable Integer idHerramienta,
            Model model) {

        var herramienta = herramientaService.getHerramienta(idHerramienta);

        if (herramienta.isEmpty()) {
            return "redirect:/herramienta/listado";
        }

        model.addAttribute("herramienta", herramienta.get());

        return "herramienta/consulta";
    }

    @GetMapping("/baja/{idHerramienta}")
    public String baja(
            @PathVariable Integer idHerramienta,
            Model model) {

        var herramienta = herramientaService.getHerramienta(idHerramienta);

        if (herramienta.isEmpty()) {
            return "redirect:/herramienta/listado";
        }

        model.addAttribute("herramienta", herramienta.get());

        return "herramienta/baja";
    }

    @PostMapping("/baja")
    public String baja(
            @RequestParam Integer idHerramienta,
            @RequestParam(required = false, defaultValue = "") String justificacion,
            Model model) {

        var herramienta = herramientaService.getHerramienta(idHerramienta);

        if (herramienta.isEmpty()) {
            return "redirect:/herramienta/listado";
        }

        if (justificacion.isBlank()) {

            model.addAttribute("herramienta", herramienta.get());
            model.addAttribute("errorJustificacion", true);

            return "herramienta/baja";
        }

        herramientaService.darDeBaja(idHerramienta, justificacion.trim());

        return "redirect:/herramienta/listado";
    }

    @GetMapping("/mantenimiento/{idHerramienta}")
    public String mantenimiento(
            @PathVariable Integer idHerramienta,
            Model model) {

        var herramienta = herramientaService.getHerramienta(idHerramienta);

        if (herramienta.isEmpty()) {
            return "redirect:/herramienta/listado";
        }

        model.addAttribute("herramienta", herramienta.get());

        return "herramienta/mantenimiento";
    }

    @PostMapping("/mantenimiento")
    public String mantenimiento(
            @RequestParam Integer idHerramienta,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaRetornoEstimada) {

        var herramienta = herramientaService.getHerramienta(idHerramienta);

        if (herramienta.isEmpty()) {
            return "redirect:/herramienta/listado";
        }

        herramientaService.enviarAMantenimiento(idHerramienta, fechaRetornoEstimada);

        return "redirect:/herramienta/listado";
    }

    @PostMapping("/disponible/{idHerramienta}")
    public String disponible(
            @PathVariable Integer idHerramienta) {

        herramientaService.marcarDisponible(idHerramienta);

        return "redirect:/herramienta/listado";
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model) {

        var herramientas = herramientaService.getCatalogoDisponible();

        model.addAttribute("herramientas", herramientas);

        return "herramienta/catalogo";
    }
}
