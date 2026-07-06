package com.telecomtrack.service.impl;

import com.telecomtrack.domain.Proveedor;
import com.telecomtrack.repository.ProveedorRepository;
import com.telecomtrack.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }

    @Override
    public Optional<Proveedor> buscarPorId(Long id) {
        return proveedorRepository.findById(id);
    }
}
