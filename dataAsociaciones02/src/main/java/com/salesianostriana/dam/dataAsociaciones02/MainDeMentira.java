package com.salesianostriana.dam.dataAsociaciones02;

import com.salesianostriana.dam.dataAsociaciones02.model.Comunidad;
import com.salesianostriana.dam.dataAsociaciones02.model.Provincia;
import com.salesianostriana.dam.dataAsociaciones02.repo.ComunidadRepo;
import com.salesianostriana.dam.dataAsociaciones02.repo.ProvinciaRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

        @Autowired
        private final ComunidadRepo comunidadRepo;
        @Autowired
        private final ProvinciaRepo provinciaRepo;

        @PostConstruct
        public void run() {

            Comunidad c = Comunidad.builder()
                    .nombre("Andalucia").build();
            comunidadRepo.save(c);
            Provincia p = Provincia.builder()
                    .nombre("Sevilla")
                    .comunidad(c)
                    .build();

            provinciaRepo.save(p);

            Provincia p2 = Provincia.builder()
                    .nombre("Córdoba")
                    .comunidad(c)
                    .build();

            c.addProducto(p);
            c.addProducto(p2);
            provinciaRepo.save(p2);
            provinciaRepo.saveAll(List.of(p, p2));

        }
}
