package com.salesianostriana.dam.ejercicioEnClase2.service;

import com.salesianostriana.dam.ejercicioEnClase2.model.Producto;
import com.salesianostriana.dam.ejercicioEnClase2.repo.ProductoRepositorio;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepositorio productoRepository;


    public List<Producto> findAll() {
        List<Producto> result = productoRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay productos con esos criterios de búsqueda");
        return result;
    }
    public Producto findById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con ID: "+ id));
    }
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }
    public Producto edit(Producto producto, Long id) {
        return productoRepository.findById(id)
                .map(old -> {
                    old.setNombre(producto.getNombre());
                    old.setPrecio(producto.getPrecio());
                    return productoRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con ID: "+ id));
    }
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
