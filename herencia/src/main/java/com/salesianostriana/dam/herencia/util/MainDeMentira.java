package com.salesianostriana.dam.herencia.util;

import com.salesianostriana.dam.herencia.modelo.Contratado;
import com.salesianostriana.dam.herencia.modelo.FacturaConIva;
import com.salesianostriana.dam.herencia.modelo.FacturaSinIva;
import com.salesianostriana.dam.herencia.modelo.Pasante;
import com.salesianostriana.dam.herencia.repo.ContratadoRepositorio;
import com.salesianostriana.dam.herencia.repo.PasanteRepositorio;
import com.salesianostriana.dam.herencia.repo.PersonaRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    // Repositorios necesarios para las distintas jerarquías
    private final FacturaSinIva facturaRepository;
    private final FacturaConIva facturaConIvaRepository;
    private final PersonaRepo personRepository;
    private final PasanteRepositorio pasanteRepository;
    private final ContratadoRepositorio contratadoRepository;

    @PostConstruct
    public void run() {

        // ** Ejemplos para Factura **
        FacturaConIva facturaConIva = new FacturaConIva(null, "F001", "Compra de materiales", 1000.0, 21);
        FacturaSinIva facturaSinIva = new FacturaSinIva(null, "F002", "Servicio de consultoría", 500.0, "Juan Pérez");

        facturaConIvaRepository.save(facturaConIva);
        facturaRepository.save(facturaSinIva);

        System.out.println("Factura con IVA: " + facturaConIva);
        System.out.println("Factura sin IVA: " + facturaSinIva);

        // ** Ejemplos para Empleado (Herencia TABLE_PER_CLASS) **
        Contratado contratado = new Contratado();
        contratado.setNombre("Carlos");
        contratado.setApellido("Ruiz");
        contratado.setSalario(2500.0);
        contratado.setLegajo(12345);

        Pasante pasante = new Pasante();
        pasante.setNombre("Ana");
        pasante.setApellido("Martínez");
        pasante.setSalarioPorHora(20.0);
        pasante.setTutor("Lucía Gómez");

        ContratadoRepositorio.save(contratado);
        PasanteRepositorio.save(pasante);

        System.out.println("Empleado contratado: " + contratado);
        System.out.println("Empleado pasante: " + pasante);

        // ** Ejemplos para Person (Herencia JOINED) **
        Student student = new Student();
        student.setFirstName("Pedro");
        student.setLastName("López");
        student.setCreated(new Date());
        student.setSchoolName("Escuela Técnica Superior");

        Professional professional = new Professional();
        professional.setFirstName("Laura");
        professional.setLastName("Fernández");
        professional.setCreated(new Date());
        professional.setCompanyName("Tech Solutions");

        personRepository.save(student);
        personRepository.save(professional);

        System.out.println("Estudiante: " + student);
        System.out.println("Profesional: " + professional);
    }
}
