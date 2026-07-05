package com.telecomtrack.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;


@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotBlank(message = "{validacion.nombre.requerido}")
    @Size(max = 50, message = "{validacion.usuario.nombre.longitud}")
    @Column(nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "{validacion.usuario.apellido.requerido}")
    @Size(max = 50, message = "{validacion.usuario.apellido.longitud}")
    @Column(nullable = false, length = 50)
    private String apellido;

    @NotBlank(message = "{validacion.usuario.correo.requerido}")
    @Email(message = "{validacion.usuario.correo.formato}")
    @Size(max = 100, message = "{validacion.usuario.correo.longitud}")
    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @NotBlank(message = "{validacion.usuario.rol.requerido}")
    @Size(max = 20, message = "{validacion.usuario.rol.longitud}")
    @Column(nullable = false, length = 20)
    private String rol;

    private boolean activo;
}
