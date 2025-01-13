package com.salesianos.dam.dataAsociaciones.repo;

import com.salesianos.dam.dataAsociaciones.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository
        extends JpaRepository<Categoria, Long> {
}
