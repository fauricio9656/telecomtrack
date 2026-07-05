package com.telecomtrack.service;

import com.telecomtrack.domain.Proveedor;
import java.util.List;
import java.util.Optional;

public interface ProveedorService {
    List<Proveedor> listarTodos();
    Optional<Proveedor> buscarPorId(Long id);
}
