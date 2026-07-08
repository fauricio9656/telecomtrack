package com.telecomtrack.service;

import com.telecomtrack.domain.Material;
import com.telecomtrack.domain.Movimiento;
import com.telecomtrack.repository.MaterialRepository;
import com.telecomtrack.repository.MovimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final MaterialRepository materialRepository;

    public MovimientoService(MovimientoRepository movimientoRepository,
                              MaterialRepository materialRepository) {
        this.movimientoRepository = movimientoRepository;
        this.materialRepository = materialRepository;
    }

    public Movimiento registrarEntrada(Long idMaterial, Integer cantidad,
                                       String observacion, String responsable) {
        Material material = materialRepository.findById(idMaterial)
                .orElseThrow(() -> new IllegalArgumentException("Material no encontrado: " + idMaterial));

        material.setStockActual(material.getStockActual() + cantidad);
        materialRepository.save(material);

        Movimiento movimiento = new Movimiento();
        movimiento.setTipo("ENTRADA");
        movimiento.setCantidad(cantidad);
        movimiento.setFecha(LocalDateTime.now());
        movimiento.setObservacion(observacion);
        movimiento.setResponsable(responsable);
        movimiento.setMaterial(material);

        return movimientoRepository.save(movimiento);
    }

    @Transactional(readOnly = true)
    public List<Movimiento> listarPorMaterial(Long idMaterial) {
        return movimientoRepository.findByMaterialIdMaterialOrderByFechaDesc(idMaterial);
    }
}
