package com.salesianostriana.dam.herencia.modelo;

import jakarta.persistence.Entity;

@Entity
public class Contratado extends Empleado {
    private double salario;
    private int legajo;
}