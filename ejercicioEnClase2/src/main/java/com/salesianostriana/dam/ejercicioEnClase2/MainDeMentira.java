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


    private final CategoriaRepositorio categoriaRepositorio;
    private final ProductoRepositorio productoRepositorio;

    @PostConstruct
    public void init() {

        Categoria c = Categoria.builder()
                .nombre("Electrónica").build();

        Optional<Categoria> optionalCategoria = categoriaRepositorio.findById(1L);

        if (optionalCategoria.isPresent()) {
            c = optionalCategoria.get();
        }

        Producto p = Producto.builder()
                .nombre("Ipad pro")
                .precio(123.45)
                //.categoria(c)
                .build();

        c.addProducto(p);

        productoRepositorio.save(p);

        System.out.println("Productos de la categoria C1");
        System.out.println(c.getProductos());

        Producto p2 = Producto.builder()
                .nombre("Iphone 2")
                .precio(234.56)
                .categoria(c)
                .build();

        productoRepositorio.saveAll(List.of(p, p2));


        productoRepositorio.findAll()
                .forEach(System.out::println);

    }
}
