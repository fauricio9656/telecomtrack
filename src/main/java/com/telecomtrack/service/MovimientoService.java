package com.telecomtrack.service;

import com.telecomtrack.domain.Movimiento;
import java.util.List;

public interface MovimientoService {

    Movimiento registrarEntrada(Long idMaterial, Integer cantidad, String observacion);

    List<Movimiento> listarPorMaterial(Long idMaterial);
}