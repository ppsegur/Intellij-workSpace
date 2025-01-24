package com.salesianostriana.dam.herencia.modelo;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@SuperBuilder
@Data
public class Contratado extends Empleado {
    private double salario;
    private int legajo;

    public Contratado(Long id, String firstName, String lastName, Date created, double salario, int legajo) {
        super(id,firstName,lastName,created);
        this.salario = salario;
        this.legajo = legajo;

    }

    public Contratado() {

    }
}