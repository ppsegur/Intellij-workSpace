package com.salesianostriana.dam.herencia.modelo;

import jakarta.persistence.Entity;

@Entity
public class Pasante extends Empleado {
    private double  salarioPorHora;
    private String tutor;
}