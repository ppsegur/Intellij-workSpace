package com.salesianostriana.dam.herencia.repo;

import com.salesianostriana.dam.herencia.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepositorio extends
        JpaRepository<Factura, Long> {
}
