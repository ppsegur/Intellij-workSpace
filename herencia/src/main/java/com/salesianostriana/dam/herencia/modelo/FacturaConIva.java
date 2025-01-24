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
@SuperBuilder
public class FacturaConIva extends Factura {

    private double iva = 21;

    public FacturaConIva(Long id,String numero, String concepto, double importe,double iva) {
        super(id,numero, concepto, importe );
        this.iva = iva;
    }


    @Override
    public double importeConIva() {
        return getImporte()*iva;
    }
}
