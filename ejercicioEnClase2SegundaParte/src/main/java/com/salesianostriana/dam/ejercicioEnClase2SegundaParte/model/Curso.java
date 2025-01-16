package com.salesianostriana.dam.ejercicioEnClase2SegundaParte.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private double puntuacion;

    @ManyToOne
    @JoinColumn(name = "profesor_id",
            foreignKey = @ForeignKey(name = "fk_curso_profesor"))
    @JsonBackReference
    private Profesor p;


}
