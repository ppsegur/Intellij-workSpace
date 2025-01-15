package com.salesianostriana.dam.dataAsociaciones02.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name="comunidades")
public class Comunidad {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "comunidad", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Provincia> provincias = new ArrayList<>();


    //Helpers
    public void addProducto(Provincia p){
        p.setComunidad(this);
        this.getProvincias().add(p);
    }

    public void remove(Provincia p){
        this.getProvincias().remove(p);
        p.setComunidad(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Comunidad comunidad = (Comunidad) o;
        return getId() != null && Objects.equals(getId(), comunidad.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
