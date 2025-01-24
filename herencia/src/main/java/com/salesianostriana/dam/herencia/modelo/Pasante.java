package com.salesianostriana.dam.herencia.modelo;

import jakarta.persistence.Entity;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
public class Pasante extends Empleado {
    private double  salarioPorHora;
    private String tutor;

    public Pasante(double salarioPorHora) {
        super();
        this.salarioPorHora = salarioPorHora;
    }
}