package com.salesianostriana.dam.ejercicioEnClase2.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue
    private long id;

    private String nombre;

    private double precio;

    //Asociación con la categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id",
            foreignKey = @ForeignKey(name = "fk_producto_categoria")
    )
    private Categoria categoria;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Producto producto = (Producto) o;
        return getId() != 0 && Objects.equals(getId(), producto.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
