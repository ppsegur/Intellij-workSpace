package com.salesianostriana.dam.herencia.repo;

import com.salesianostriana.dam.herencia.modelo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositorio extends JpaRepository<Student, Integer> {
}
