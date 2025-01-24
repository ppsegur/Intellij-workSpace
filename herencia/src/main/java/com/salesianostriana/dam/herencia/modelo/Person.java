package com.salesianostriana.dam.herencia.modelo;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
//Herencia JOINED (PERSON-STUDENT-PROFESSIONAL)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE", discriminatorType= DiscriminatorType.INTEGER)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String firstName;
    private String lastName;
    private Date created;


}