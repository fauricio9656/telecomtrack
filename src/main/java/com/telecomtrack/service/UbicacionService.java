package com.telecomtrack.service;

import com.telecomtrack.domain.Ubicacion;
import com.telecomtrack.repository.UbicacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Optional<Ubicacion> getUbicacion(Integer idUbicacion) {
        return ubicacionRepository.findById(idUbicacion);
    }

    @Transactional
    public void save(Ubicacion ubicacion) {
        ubicacionRepository.save(ubicacion);
    }
}