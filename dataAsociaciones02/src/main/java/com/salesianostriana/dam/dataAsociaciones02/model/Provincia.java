package com.salesianostriana.dam.dataAsociaciones02.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="provincia")
public class Provincia {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "comunidad_id",
            foreignKey = @ForeignKey(name = "fk_provincia_comunidad"))
    private Comunidad comunidad;

    //Helper
    public void addProvincia(Provincia provincia) {

    }
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Provincia provincia = (Provincia) o;
        return getId() != null && Objects.equals(getId(), provincia.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
