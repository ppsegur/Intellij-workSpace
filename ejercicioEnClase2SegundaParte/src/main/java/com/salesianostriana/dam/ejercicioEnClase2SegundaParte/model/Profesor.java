package com.salesianostriana.dam.ejercicioEnClase2SegundaParte.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "profesor")
public class Profesor {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String email;
    private double puntuacion;
    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    @JsonManagedReference
    private List<Curso> cursosOnline = new ArrayList<>();

    // Métodos helper
    public void addProducto(Curso p) {
        p.setP(this);
        this.getCursosOnline().add(p);
    }

    public void removeProducto(Curso p) {
        this.getCursosOnline().remove(p);
        p.setP(null);
    }
}
