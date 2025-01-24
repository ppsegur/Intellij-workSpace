package com.salesianostriana.dam.herencia.modelo;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Data
@SuperBuilder
public class Pasante extends Empleado {
    private double  salarioPorHora;
    private String tutor;

    public Pasante(Long id,String firstName,String lastName, Date created,double salarioPorHora,String tutor) {
        super(id,firstName,lastName,created);
        this.salarioPorHora = salarioPorHora;
        this.tutor = tutor;
    }

    public Pasante() {

    }

}