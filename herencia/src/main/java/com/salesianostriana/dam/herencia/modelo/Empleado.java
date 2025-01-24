package com.salesianostriana.dam.herencia.modelo;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.Date;


//Herencia Single Table (EMPLEADO-PASANTE-CONTRATADO)
@Entity
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Empleado {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;


    public Empleado(Long id, String firstName, String lastName, Date created) {
    }

    public Empleado() {

    }
}