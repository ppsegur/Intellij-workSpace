package com.salesianostriana.dam.herencia.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@MappedSuperclass //Uso de la anotación MappedSuperClass
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Factura {
    @Id
    @GeneratedValue
    private Long id;

    private String numero;
    private String concepto;
    private double importe;

    public  double importeConIva(){
        return importe;
    };


}