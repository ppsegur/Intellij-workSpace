package com.salesianostriana.dam.ejercicioEnClase2.repo;

import com.salesianostriana.dam.ejercicioEnClase2.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
}
