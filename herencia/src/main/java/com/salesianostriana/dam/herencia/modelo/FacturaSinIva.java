package com.salesianostriana.dam.herencia.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder
@Builder
@DiscriminatorValue("Sin iva")
public class FacturaSinIva extends  Factura{

    private String nombreTitular;

    @Override
    public double importeConIva() {
        return getImporte();
    }


}
