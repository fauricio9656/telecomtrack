package com.telecomtrack.service;

import com.telecomtrack.domain.Ubicacion;
import com.telecomtrack.repository.UbicacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UbicacionService {

    private final UbicacionRepository ubicacionRepository;

    public UbicacionService(UbicacionRepository ubicacionRepository) {
        this.ubicacionRepository = ubicacionRepository;
    }

    @Transactional(readOnly = true)
    public List<Ubicacion> getUbicaciones() {
        return ubicacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Ubicacion getUbicacion(Ubicacion ubicacion) {
        return ubicacionRepository
                .findById(ubicacion.getIdUbicacion())
                .orElse(null);
    }

    @Transactional
    public void save(Ubicacion ubicacion) {
        ubicacionRepository.save(ubicacion);
    }
}