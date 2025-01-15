package com.salesianostriana.dam.dataAsociaciones02.repo;

import com.salesianostriana.dam.dataAsociaciones02.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepo
        extends JpaRepository<Provincia, Long> {
}
