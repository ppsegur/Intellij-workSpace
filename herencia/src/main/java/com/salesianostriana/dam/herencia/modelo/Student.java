package com.salesianostriana.dam.herencia.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="PERSON_STUDENT")
@DiscriminatorValue("1")
public class Student extends Person {


    private String schoolName;

}
