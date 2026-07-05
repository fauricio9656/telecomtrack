package com.telecomtrack.service.impl;

import com.telecomtrack.domain.Material;
import com.telecomtrack.repository.MaterialRepository;
import com.telecomtrack.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Material> listarTodos() {
        return materialRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Material> listarConStockBajo() {
        return materialRepository.findMaterialesConStockBajo();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Material> buscarPorId(Long id) {
        return materialRepository.findById(id);
    }

    @Override
    public Material guardar(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public void eliminar(Long id) {
        materialRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeCodigoUnico(String codigo) {
        return materialRepository.existsByCodigoUnico(codigo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeCodigoUnicoExcluyendo(String codigo, Long id) {
        return materialRepository.existsByCodigoUnicoAndIdMaterialNot(codigo, id);
    }
}