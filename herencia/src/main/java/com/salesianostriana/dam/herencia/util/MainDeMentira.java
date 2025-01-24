package com.salesianostriana.dam.herencia.util;

import com.salesianostriana.dam.herencia.modelo.*;
import com.salesianostriana.dam.herencia.repo.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    // Repositorios necesarios para las distintas jerarquías

    private final PersonaRepo personRepository;
    private final PasanteRepositorio pasanteRepository;
    private final ContratadoRepositorio contratadoRepository;
    private final FacturaConIvaRepositorio facturaConIvaRepositorio;
    private final FacturaSinIvaRepositorio facturaSinIvaRepositorio;


    @PostConstruct
    public void run() {

        // ** Ejemplos para Factura **
        FacturaConIva facturaConIva = (FacturaConIva) FacturaConIva.builder()
                .numero("F001")
                .concepto("Compra de materiales")
                .importe(1000.0)
                .build();

        FacturaSinIva facturaSinIva = (FacturaSinIva) FacturaSinIva.builder()
                .numero("F002")
                .concepto("Servicio de consultoría")
                .importe(500.0)
                .build();

        facturaConIvaRepositorio.save(facturaConIva);
        facturaSinIvaRepositorio.save(facturaSinIva);

        System.out.println("Factura con IVA: " + facturaConIva);
        System.out.println("Factura sin IVA: " + facturaSinIva);

        // ** Ejemplos para Empleado (Herencia TABLE_PER_CLASS) **
        Contratado contratado = Contratado.builder()
                .nombre("Carlos")
                .apellido("Ruiz")
                .salario(2500.0)
                .legajo(12345)
                .build();

        Pasante pasante = Pasante.builder()
                .nombre("Ana")
                .apellido("Martínez")
                .salarioPorHora(20.0)
                .tutor("Lucía Gómez")
                .build();

        contratadoRepository.save(contratado);
        pasanteRepository.save(pasante);

        System.out.println("Empleado contratado: " + contratado);
        System.out.println("Empleado pasante: " + pasante);

        // ** Ejemplos para Person (Herencia JOINED) **
        Student student = (Student) Student.builder()
                .firstName("Pedro")
                .lastName("López")
                .created(new Date())
                .build();

        Professional professional = (Professional) Professional.builder()
                .firstName("Laura")
                .lastName("Fernández")
                .created(new Date())
                .build();

        personRepository.save(student);
        personRepository.save(professional);

        System.out.println("Estudiante: " + student);
        System.out.println("Profesional: " + professional);
    }
}
