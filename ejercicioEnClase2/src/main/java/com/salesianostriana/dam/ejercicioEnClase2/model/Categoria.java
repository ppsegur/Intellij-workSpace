package com.salesianostriana.dam.ejercicioEnClase2.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.*;


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



    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private Set<Producto> productos = new HashSet<>();


    //Asociación refléxiva
    @ManyToOne
    @JoinColumn(name = "categoria_reacion_id",
            foreignKey =  @ForeignKey(name = "fk_categoriPadre_categoria"))
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private Set<Categoria> listaCategoriasHijas = new HashSet<>();



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

        p.setCategoria(this);
        this.productos.add(p);
    }

    public void removeProducto(Producto p){
        this.productos.remove(p);
        p.setCategoria(null);
    }

    //Métodos helper(categoria)
    public void addCategoria(Categoria c){
        c.setCategoriaPadre(this);
        this.listaCategoriasHijas.add(c);
    }
    public void removeCategoria(Categoria c){
        this.listaCategoriasHijas.remove(c);
        c.setCategoriaPadre(null);

    }
}
