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

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres.")
    @Column(nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío.")
    @Size(max = 50, message = "El apellido no puede tener más de 50 caracteres.")
    @Column(nullable = false, length = 50)
    private String apellido;

    @NotBlank(message = "El correo no puede estar vacío.")
    @Email(message = "El correo debe tener un formato válido.")
    @Size(max = 100, message = "El correo no puede tener más de 100 caracteres.")
    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @NotBlank(message = "Debe seleccionar un rol.")
    @Size(max = 20, message = "El rol no puede tener más de 20 caracteres.")
    @Column(nullable = false, length = 20)
    private String rol;

    private boolean activo;
}
