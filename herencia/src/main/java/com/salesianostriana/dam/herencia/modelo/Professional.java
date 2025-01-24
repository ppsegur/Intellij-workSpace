package com.salesianostriana.dam.herencia.modelo;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="PERSON_PROFESSIONAL")
@DiscriminatorValue("2")
public class Professional extends Person {

    private String companyName;


}
