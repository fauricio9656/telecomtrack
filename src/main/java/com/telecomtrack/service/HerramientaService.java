package com.telecomtrack.service;

import com.telecomtrack.domain.Herramienta;
import com.telecomtrack.repository.HerramientaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HerramientaService {

    private final HerramientaRepository herramientaRepository;

    public HerramientaService(HerramientaRepository herramientaRepository) {
        this.herramientaRepository = herramientaRepository;
    }

    @Transactional(readOnly = true)
    public List<Herramienta> getHerramientas() {
        return herramientaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Herramienta> getHerramienta(Integer idHerramienta) {
        return herramientaRepository.findById(idHerramienta);
    }

    @Transactional(readOnly = true)
    public List<Herramienta> getCatalogoDisponible() {
        return herramientaRepository.findByEstado(Herramienta.ESTADO_DISPONIBLE);
    }

    @Transactional(readOnly = true)
    public boolean existeCodigo(String codigo) {
        return herramientaRepository.existsByCodigo(codigo);
    }

    @Transactional(readOnly = true)
    public boolean existeCodigoEnOtra(String codigo, Integer idHerramienta) {
        return herramientaRepository.existsByCodigoAndIdHerramientaNot(codigo, idHerramienta);
    }

    @Transactional
    public void save(Herramienta herramienta) {
        herramientaRepository.save(herramienta);
    }

    @Transactional
    public void darDeBaja(Integer idHerramienta, String justificacion) {

        var herramienta = herramientaRepository.findById(idHerramienta);

        if (herramienta.isEmpty()) {
            return;
        }

        var actual = herramienta.get();

        actual.setEstado(Herramienta.ESTADO_BAJA);
        actual.setFechaBaja(LocalDate.now());
        actual.setJustificacionBaja(justificacion);
        actual.setFechaRetornoEstimada(null);

        herramientaRepository.save(actual);
    }

    @Transactional
    public void enviarAMantenimiento(Integer idHerramienta, LocalDate fechaRetornoEstimada) {

        var herramienta = herramientaRepository.findById(idHerramienta);

        if (herramienta.isEmpty()) {
            return;
        }

        var actual = herramienta.get();

        actual.setEstado(Herramienta.ESTADO_MANTENIMIENTO);
        actual.setFechaRetornoEstimada(fechaRetornoEstimada);

        herramientaRepository.save(actual);
    }

    @Transactional
    public void marcarDisponible(Integer idHerramienta) {

        var herramienta = herramientaRepository.findById(idHerramienta);

        if (herramienta.isEmpty()) {
            return;
        }

        var actual = herramienta.get();

        actual.setEstado(Herramienta.ESTADO_DISPONIBLE);
        actual.setFechaRetornoEstimada(null);

        herramientaRepository.save(actual);
    }
}
