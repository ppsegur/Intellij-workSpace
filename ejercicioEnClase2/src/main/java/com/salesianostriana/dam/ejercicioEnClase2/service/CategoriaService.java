package com.salesianostriana.dam.ejercicioEnClase2.service;

import com.salesianostriana.dam.ejercicioEnClase2.model.Categoria;
import com.salesianostriana.dam.ejercicioEnClase2.repo.CategoriaRepositorio;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepositorio categoriaRepository;

    public List<Categoria> findAll() {
        List<Categoria> result = categoriaRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay categorias con esos criterios de búsqueda");
        return result;
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay categoria con ID: " + id));

    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria edit(Categoria categoria, Long id) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(categoria.getNombre());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay categoria con ID: " + id));

    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

}