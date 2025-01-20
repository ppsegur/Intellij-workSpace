package com.salesianos.dam.dataAsociaciones.service;

import com.salesianos.dam.dataAsociaciones.dto.EditCategoryCmd;
import com.salesianos.dam.dataAsociaciones.model.Categoria;
import com.salesianos.dam.dataAsociaciones.model.Producto;
import com.salesianos.dam.dataAsociaciones.repo.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        List<Categoria> result = categoriaRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay categorias con esos criterios de búsqueda");
        return result;
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay categoria con ID: " + id));

    }/*
 return productoRepository.save(Producto.builder()
         .nombre(nuevo.nombre())
            .precio(nuevo.precio())
            //.categoria(categoriaRepository.getReferenceById(nuevo.categoriaId()))
            .categoria(categoriaRepository.findById(nuevo.categoriaId()).orElse(null))
            .descripcion(nuevo.descripcion())
            .build());
}
*/
    public Categoria save(EditCategoryCmd categoria) {
        return   categoriaRepository.save(Categoria.builder().nombre(categoria.nombre()).productos(categoria.productoId());

    }

    public Categoria edit(EditCategoryCmd categoria, Long id) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(categoria.nombre());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay categoria con ID: " + id));

    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
