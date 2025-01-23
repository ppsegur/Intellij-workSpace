package com.salesianostriana.dam.herencia.repo;

import com.salesianostriana.dam.herencia.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturaRepositorio extends
        JpaRepository<Factura, Long> {

    //Select * from Factura where numero like ="numero"
    List<Factura> findByNumero(String numero);
    //List<Factura> == tipo de retorno
    //FindBy == sujeto
    //Lo que sea despues del find by sera el predicado y lo que definira
    //los ajustes de busquedad

    //Devolverá las 10 facturas mas baratas
    List<Factura> findTop10ByOrderByImporteDesc();
}
