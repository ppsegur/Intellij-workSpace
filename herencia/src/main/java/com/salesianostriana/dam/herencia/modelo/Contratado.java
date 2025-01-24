package com.salesianostriana.dam.herencia.modelo;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
public class Contratado extends Empleado {
    private double salario;
    private int legajo;

    public Contratado() {
        super();
    }
}