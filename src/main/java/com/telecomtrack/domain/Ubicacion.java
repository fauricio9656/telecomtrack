package com.telecomtrack.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ubicacion")
public class Ubicacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion")
    private Integer idUbicacion;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Size(max = 255, message = "La descripción no puede tener más de 255 caracteres.")
    @Column(length = 255)
    private String descripcion;

    @NotBlank(message = "El responsable no puede estar vacío.")
    @Size(max = 100, message = "El responsable no puede tener más de 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String responsable;
}