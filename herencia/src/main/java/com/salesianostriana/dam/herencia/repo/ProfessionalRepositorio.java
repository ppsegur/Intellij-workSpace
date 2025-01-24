package com.salesianostriana.dam.herencia.repo;

import com.salesianostriana.dam.herencia.modelo.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepositorio extends JpaRepository<Professional, Long> {
}
