package com.salesianostriana.dam.ejercicioEnClase2;

import com.salesianostriana.dam.ejercicioEnClase2.model.Categoria;
import com.salesianostriana.dam.ejercicioEnClase2.model.Producto;
import com.salesianostriana.dam.ejercicioEnClase2.repo.CategoriaRepositorio;
import com.salesianostriana.dam.ejercicioEnClase2.repo.ProductoRepositorio;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepositorio productoRepository;
    private final CategoriaRepositorio categoriaRepository;

    @PostConstruct
    public void init() {

        Categoria c = Categoria.builder()
                .nombre("Alimentación")
                .build();

        Categoria c2 = Categoria.builder()
                .nombre("Verde")
                .categoriaPadre(c)
                .build();

        Categoria c3 = Categoria.builder()
                .nombre("Líquido")
                .build();

        categoriaRepository.save(c);
        categoriaRepository.save(c2);
        categoriaRepository.save(c3);

        Producto p = Producto.builder()
                .nombre("Lechuga")
                .precio(2.30)
                .categoria(c)
                .build();

        productoRepository.save(p);
        System.out.printf(c.toString());
    }
}