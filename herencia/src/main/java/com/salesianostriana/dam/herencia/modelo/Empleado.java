package com.salesianostriana.dam.herencia.modelo;

import jakarta.persistence.*;
import lombok.Builder;


//Herencia Single Table (EMPLEADO-PASANTE-CONTRATADO)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Empleado {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;


}