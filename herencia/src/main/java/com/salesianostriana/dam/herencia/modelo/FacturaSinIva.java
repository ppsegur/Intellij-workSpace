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
@SuperBuilder
@DiscriminatorValue("Sin iva")
public class FacturaSinIva extends  Factura{

    private String nombreTitular;

    public FacturaSinIva(Long id,String numero, String concepto, double importe,String nombreTitular) {
        super(id,numero, concepto, importe);
        this.nombreTitular = nombreTitular;
    }
    @Override
    public double importeConIva() {
        return getImporte();
    }


}
