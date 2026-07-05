package com.telecomtrack.controller;

import com.telecomtrack.domain.Material;
import com.telecomtrack.service.CategoriaService;
import com.telecomtrack.service.MaterialService;
import com.telecomtrack.service.MovimientoService;
import com.telecomtrack.service.ProveedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
    private final CategoriaService categoriaService;
    private final ProveedorService proveedorService;
    private final MessageSource messageSource;

    private String msg(String key, Object... args) {
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }

    @GetMapping
    public String lista(Model model) {
        model.addAttribute("materiales", materialService.listarTodos());
        model.addAttribute("alertas", materialService.listarConStockBajo());
        return "materiales/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("material", new Material());
        model.addAttribute("categorias", categoriaService.listarTodas());
        model.addAttribute("proveedores", proveedorService.listarTodos());
        return "materiales/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes flash) {
        return materialService.buscarPorId(id).map(m -> {
            model.addAttribute("material", m);
            model.addAttribute("categorias", categoriaService.listarTodas());
            model.addAttribute("proveedores", proveedorService.listarTodos());
            return "materiales/formulario";
        }).orElseGet(() -> {
            flash.addFlashAttribute("error", msg("mat.msg.noEncontrado"));
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
            categoriaService.buscarPorId(categoriaId).ifPresent(material::setCategoria);
        }
        if (proveedorId != null) {
            proveedorService.buscarPorId(proveedorId).ifPresent(material::setProveedor);
        }

        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaService.listarTodas());
            model.addAttribute("proveedores", proveedorService.listarTodos());
            return "materiales/formulario";
        }

        boolean esNuevo = material.getIdMaterial() == null;
        boolean duplicado = esNuevo
                ? materialService.existeCodigoUnico(material.getCodigoUnico())
                : materialService.existeCodigoUnicoExcluyendo(material.getCodigoUnico(), material.getIdMaterial());

        if (duplicado) {
            result.rejectValue("codigoUnico", "error.material", msg("mat.msg.codigoDuplicado"));
            model.addAttribute("categorias", categoriaService.listarTodas());
            model.addAttribute("proveedores", proveedorService.listarTodos());
            return "materiales/formulario";
        }

        materialService.guardar(material);
        flash.addFlashAttribute("exitoo", msg(esNuevo ? "mat.msg.creado" : "mat.msg.actualizado"));
        return "redirect:/materiales";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
        try {
            materialService.eliminar(id);
            flash.addFlashAttribute("exitoo", msg("mat.msg.eliminado"));
        } catch (Exception e) {
            flash.addFlashAttribute("error", msg("mat.msg.errorEliminar"));
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
            flash.addFlashAttribute("error", msg("mat.msg.noEncontrado"));
            return "redirect:/materiales";
        });
    }

    @PostMapping("/{id}/entrada")
    public String registrarEntrada(@PathVariable Long id,
                                    @RequestParam Integer cantidad,
                                    @RequestParam(required = false) String observacion,
                                    RedirectAttributes flash) {
        if (cantidad == null || cantidad < 1) {
            flash.addFlashAttribute("error", msg("mat.msg.cantidadInvalida"));
            return "redirect:/materiales/" + id + "/entrada";
        }
        movimientoService.registrarEntrada(id, cantidad, observacion);
        flash.addFlashAttribute("exitoo", msg("mat.msg.entradaRegistrada", cantidad));
        return "redirect:/materiales";
    }
}
