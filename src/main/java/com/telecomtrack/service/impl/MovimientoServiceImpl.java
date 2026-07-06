package com.telecomtrack.service.impl;

import com.telecomtrack.domain.Material;
import com.telecomtrack.domain.Movimiento;
import com.telecomtrack.repository.MaterialRepository;
import com.telecomtrack.repository.MovimientoRepository;
import com.telecomtrack.service.MovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final MaterialRepository materialRepository;

    @Override
    public Movimiento registrarEntrada(Long idMaterial, Integer cantidad, String observacion, String responsable) {
        Material material = materialRepository.findById(idMaterial)
                .orElseThrow(() -> new IllegalArgumentException("Material no encontrado: " + idMaterial));

        material.setStockActual(material.getStockActual() + cantidad);
        materialRepository.save(material);

        Movimiento movimiento = Movimiento.builder()
                .tipo("ENTRADA")
                .cantidad(cantidad)
                .fecha(LocalDateTime.now())
                .observacion(observacion)
                .responsable(responsable)
                .material(material)
                .build();

        return movimientoRepository.save(movimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> listarPorMaterial(Long idMaterial) {
        return movimientoRepository.findByMaterialIdMaterialOrderByFechaDesc(idMaterial);
    }
}