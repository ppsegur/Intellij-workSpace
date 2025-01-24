package com.salesianostriana.dam.herencia.modelo;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;
//Herencia JOINED (PERSON-STUDENT-PROFESSIONAL)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@SuperBuilder
@DiscriminatorColumn(name="TYPE", discriminatorType= DiscriminatorType.INTEGER)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String firstName;
    private String lastName;
    private Date created;

    public Person(Long id, String firstName, String lastName, Date created) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = created;

    }

    public Person() {

    }
}