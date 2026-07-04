package com.telecomtrack.controller;

import com.telecomtrack.domain.Material;
import com.telecomtrack.repository.CategoriaRepository;
import com.telecomtrack.repository.ProveedorRepository;
import com.telecomtrack.service.MaterialService;
import com.telecomtrack.service.MovimientoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/materiales")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService materialService;
    private final MovimientoService movimientoService;
    private final CategoriaRepository categoriaRepository;
    private final ProveedorRepository proveedorRepository;

    @GetMapping
    public String lista(Model model) {
        model.addAttribute("materiales", materialService.listarTodos());
        model.addAttribute("alertas", materialService.listarConStockBajo());
        return "materiales/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("material", new Material());
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("proveedores", proveedorRepository.findAll());
        return "materiales/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes flash) {
        return materialService.buscarPorId(id).map(m -> {
            model.addAttribute("material", m);
            model.addAttribute("categorias", categoriaRepository.findAll());
            model.addAttribute("proveedores", proveedorRepository.findAll());
            return "materiales/formulario";
        }).orElseGet(() -> {
            flash.addFlashAttribute("error", "Material no encontrado");
            return "redirect:/materiales";
        });
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("material") Material material,
                          BindingResult result,
                          @RequestParam(required = false) Long categoriaId,
                          @RequestParam(required = false) Long proveedorId,
                          Model model, RedirectAttributes flash) {

        if (categoriaId != null) {
            categoriaRepository.findById(categoriaId).ifPresent(material::setCategoria);
        }
        if (proveedorId != null) {
            proveedorRepository.findById(proveedorId).ifPresent(material::setProveedor);
        }

        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaRepository.findAll());
            model.addAttribute("proveedores", proveedorRepository.findAll());
            return "materiales/formulario";
        }

        boolean esNuevo = material.getIdMaterial() == null;
        boolean duplicado = esNuevo
                ? materialService.existeCodigoUnico(material.getCodigoUnico())
                : materialService.existeCodigoUnicoExcluyendo(material.getCodigoUnico(), material.getIdMaterial());

        if (duplicado) {
            result.rejectValue("codigoUnico", "error.material", "Este codigo ya esta en uso");
            model.addAttribute("categorias", categoriaRepository.findAll());
            model.addAttribute("proveedores", proveedorRepository.findAll());
            return "materiales/formulario";
        }

        materialService.guardar(material);
        flash.addFlashAttribute("exito", "Material " + (esNuevo ? "creado" : "actualizado") + " correctamente");
        return "redirect:/materiales";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
        try {
            materialService.eliminar(id);
            flash.addFlashAttribute("exito", "Material eliminado correctamente");
        } catch (Exception e) {
            flash.addFlashAttribute("error", "No se pudo eliminar el material");
        }
        return "redirect:/materiales";
    }

    @GetMapping("/{id}/entrada")
    public String formularioEntrada(@PathVariable Long id, Model model, RedirectAttributes flash) {
        return materialService.buscarPorId(id).map(m -> {
            model.addAttribute("material", m);
            model.addAttribute("movimientos", movimientoService.listarPorMaterial(id));
            return "materiales/entrada-stock";
        }).orElseGet(() -> {
            flash.addFlashAttribute("error", "Material no encontrado");
            return "redirect:/materiales";
        });
    }

    @PostMapping("/{id}/entrada")
    public String registrarEntrada(@PathVariable Long id,
                                   @RequestParam Integer cantidad,
                                   @RequestParam(required = false) String observacion,
                                   RedirectAttributes flash) {
        if (cantidad == null || cantidad < 1) {
            flash.addFlashAttribute("error", "La cantidad debe ser mayor a 0");
            return "redirect:/materiales/" + id + "/entrada";
        }
        movimientoService.registrarEntrada(id, cantidad, observacion);
        flash.addFlashAttribute("exito", "Entrada de " + cantidad + " unidades registrada correctamente");
        return "redirect:/materiales";
    }
}