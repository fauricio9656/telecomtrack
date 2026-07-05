package com.telecomtrack.controller;

import com.telecomtrack.domain.Usuario;
import com.telecomtrack.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    private void agregarRoles(Model model) {
        String[] roles = {
                "Administrador",
                "Bodeguero",
                "Técnico",
                "Supervisor"
        };

        model.addAttribute("roles", roles);
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var usuarios = usuarioService.getUsuarios(false);

        model.addAttribute("usuarios", usuarios);

        return "usuario/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Usuario usuario, Model model) {
        usuario.setActivo(true);

        agregarRoles(model);

        return "usuario/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(
            @Valid Usuario usuario,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            agregarRoles(model);
            return "usuario/modifica";
        }

        usuarioService.save(usuario);

        return "redirect:/usuario/listado";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String modificar(
            @PathVariable Integer idUsuario,
            Model model) {

        var usuario = usuarioService.getUsuario(idUsuario);

        if (usuario.isEmpty()) {
            return "redirect:/usuario/listado";
        }

        model.addAttribute("usuario", usuario.get());
        agregarRoles(model);

        return "usuario/modifica";
    }

    @PostMapping("/desactivar")
    public String desactivar(
            @RequestParam Integer idUsuario) {

        usuarioService.desactivar(idUsuario);

        return "redirect:/usuario/listado";
    }


}