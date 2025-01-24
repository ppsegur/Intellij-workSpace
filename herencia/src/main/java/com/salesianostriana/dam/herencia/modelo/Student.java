package com.salesianostriana.dam.herencia.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="PERSON_STUDENT")
@SuperBuilder
@DiscriminatorValue("1")
public class Student extends Person {


    private String schoolName;

    public Student() {

    }
}
