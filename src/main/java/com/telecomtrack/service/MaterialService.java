package com.telecomtrack.service;

import com.telecomtrack.domain.Material;
import java.util.List;
import java.util.Optional;

public interface MaterialService {

    List<Material> listarTodos();

    List<Material> listarConStockBajo();

    Optional<Material> buscarPorId(Long id);

    Material guardar(Material material);

    void eliminar(Long id);

    boolean existeCodigoUnico(String codigo);

    boolean existeCodigoUnicoExcluyendo(String codigo, Long id);
}