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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="categorias")
public class Categoria {

    @Id
    @GeneratedValue
    private Long   id;

    private String nombre;

    public Categoria(String nombre) {
     this.nombre = nombre;
    }

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Producto> productos = new ArrayList<Producto>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Categoria categoria = (Categoria) o;
        return getId() != null && Objects.equals(getId(), categoria.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    //Métodos helpers
    public void addProducto(Producto p){
        if (this.productos == null) {
            this.productos = new ArrayList<>();
        }
        p.setCategoria(this);
        this.productos.add(p);
    }

    public void removeProducto(Producto p){
        this.getProductos().remove(p);
        p.setCategoria(null);
    }
}
