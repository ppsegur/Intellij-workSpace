package com.salesianos.dam.dataAsociaciones;

import com.salesianos.dam.dataAsociaciones.model.Categoria;
import com.salesianos.dam.dataAsociaciones.model.Producto;
import com.salesianos.dam.dataAsociaciones.repo.CategoriaRepository;
import com.salesianos.dam.dataAsociaciones.repo.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @PostConstruct
    public void run() {

        Categoria c = categoriaRepository.getReferenceById(1L);

        Producto p = Producto.builder()
                .nombre("Un producto")
                .descripcion("Se trata de un producto de nuestro catálogo")
                .precio(123.45)
                .categoria(c)
                .build();


        productoRepository.save(p);

        Producto p2 = Producto.builder()
                .nombre("Otro producto")
                .descripcion("Verás como tiene ID 3")
                .precio(234.56)
                .categoria(c)
                .build();

        productoRepository.saveAll(List.of(p, p2));


    }
}