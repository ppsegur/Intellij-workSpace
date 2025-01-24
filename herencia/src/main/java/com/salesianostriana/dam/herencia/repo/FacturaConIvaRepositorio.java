package com.salesianostriana.dam.herencia.repo;

import com.salesianostriana.dam.herencia.modelo.FacturaConIva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturaConIvaRepositorio extends
        JpaRepository<FacturaConIva, Long> {

    //Select * from Factura where numero like ="numero"
    List<FacturaConIva> findByNumero(String numero);
    //List<Factura> == tipo de retorno
    //FindBy == sujeto
    //Lo que sea despues del find by sera el predicado y lo que definira
    //los ajustes de busquedad

    //Devolverá las 10 facturas mas baratas
    List<FacturaConIva> findTop10ByOrderByImporteDesc();
}
