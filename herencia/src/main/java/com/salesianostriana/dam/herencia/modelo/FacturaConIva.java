package com.salesianostriana.dam.herencia.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@SuperBuilder
@Builder
public class FacturaConIva extends Factura {

    private double iva;

    @Override
    public double importeConIva() {
        return getImporte()*iva;
    }
}
