package com.salesianostriana.dam.herencia.modelo;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Table(name="PERSON_PROFESSIONAL")
@SuperBuilder
@DiscriminatorValue("2")
public class Professional extends Person {

    private String companyName;


    public Professional(Long id, String firstName, String lastName, Date created) {
        super(id, firstName, lastName, created);
    }

    public Professional() {
        super();
    }
}
