package com.salesianostriana.dam.herencia.repo;

import com.salesianostriana.dam.herencia.modelo.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepo extends JpaRepository<Person, Long> {

    public final static String FIND_BY_ADDRESS_QUERY = "SELECT p " +
            "FROM Person p LEFT JOIN p.addresses a " +
            "WHERE a.address = :address";

    //Buscar por primer nombre
    public List<Person> findByFirstNameLike(String firstName);

    //Buscar por lastName
    public List<Person> findByLastName(String lastName);


}
