package com.telecomtrack.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "herramienta")
public class Herramienta implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String ESTADO_DISPONIBLE = "DISPONIBLE";
    public static final String ESTADO_MANTENIMIENTO = "MANTENIMIENTO";
    public static final String ESTADO_BAJA = "BAJA";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_herramienta")
    private Integer idHerramienta;

    @NotBlank(message = "{validacion.herramienta.codigo.requerido}")
    @Size(max = 50, message = "{validacion.herramienta.codigo.longitud}")
    @Column(nullable = false, length = 50, unique = true)
    private String codigo;

    @NotBlank(message = "{validacion.herramienta.nombre.requerido}")
    @Size(max = 100, message = "{validacion.herramienta.nombre.longitud}")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Size(max = 255, message = "{validacion.herramienta.descripcion.longitud}")
    @Column(length = 255)
    private String descripcion;

    @Column(nullable = false, length = 20)
    private String estado = ESTADO_DISPONIBLE;

    @Column(name = "fecha_baja")
    private LocalDate fechaBaja;

    @Size(max = 255, message = "{validacion.herramienta.justificacion.longitud}")
    @Column(name = "justificacion_baja", length = 255)
    private String justificacionBaja;

    @Column(name = "fecha_retorno_estimada")
    private LocalDate fechaRetornoEstimada;
}
