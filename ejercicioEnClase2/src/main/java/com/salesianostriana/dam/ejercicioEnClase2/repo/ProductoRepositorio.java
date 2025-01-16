package com.salesianostriana.dam.ejercicioEnClase2.repo;

import com.salesianostriana.dam.ejercicioEnClase2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
