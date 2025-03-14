package com.universidad.ppooii.apirest.repositories;


import com.universidad.ppooii.apirest.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {

    public abstract Persona findByidentificacion(long identificacion);
    public abstract List<Persona> findByedad(int edad);


    public abstract List<Persona> findBypapellido(String papellido);
    public abstract List<Persona> findBypnombre(String p_nombre);


}
