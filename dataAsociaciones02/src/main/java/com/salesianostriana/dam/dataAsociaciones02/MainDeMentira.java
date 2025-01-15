package com.salesianostriana.dam.dataAsociaciones02;

import com.salesianostriana.dam.dataAsociaciones02.model.Comunidad;
import com.salesianostriana.dam.dataAsociaciones02.model.Provincia;
import com.salesianostriana.dam.dataAsociaciones02.repo.ComunidadRepo;
import com.salesianostriana.dam.dataAsociaciones02.repo.ProvinciaRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

        private final ComunidadRepo comunidadRepo;
        private final ProvinciaRepo provinciaRepo;

        @PostConstruct
        public void run() {

            Comunidad c = comunidadRepo.getReferenceById(1L);

            Provincia p = Provincia.builder()
                    .nombre("Sevilla")
                    .comunidad(c)
                    .build();

            provinciaRepo.save(p);

            Provincia p2 = Provincia.builder()
                    .nombre("Córdoba")
                    .comunidad(c)
                    .build();
        }
}
