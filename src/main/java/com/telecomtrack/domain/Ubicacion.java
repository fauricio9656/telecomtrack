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

    @NotBlank(message = "{validacion.nombre.requerido}")
    @Size(max = 100, message = "{validacion.ubicacion.nombre.longitud}")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Size(max = 255, message = "{validacion.ubicacion.descripcion.longitud}")
    @Column(length = 255)
    private String descripcion;

    @NotBlank(message = "{validacion.ubicacion.responsable.requerido}")
    @Size(max = 100, message = "{validacion.ubicacion.responsable.longitud}")
    @Column(nullable = false, length = 100)
    private String responsable;
}