package com.salesianostriana.dam.herencia.repo;

import com.salesianostriana.dam.herencia.modelo.Pasante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasanteRepositorio extends JpaRepository<Pasante, Long> {
}
