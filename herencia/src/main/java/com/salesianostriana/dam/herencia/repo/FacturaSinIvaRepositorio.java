package com.salesianostriana.dam.herencia.repo;

import com.salesianostriana.dam.herencia.modelo.FacturaSinIva;
import org.springframework.data.jpa.repository.JpaRepository;

//Repo factura sin iva
public interface FacturaSinIvaRepositorio extends JpaRepository<FacturaSinIva, Long> {

}
