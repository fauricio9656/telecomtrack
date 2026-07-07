package com.telecomtrack.repository;

import com.telecomtrack.domain.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Integer> {

    boolean existsByCodigo(String codigo);

    boolean existsByCodigoAndIdHerramientaNot(String codigo, Integer idHerramienta);

    List<Herramienta> findByEstado(String estado);

    List<Herramienta> findByEstadoNot(String estado);
}
