package com.ppooii.proyecto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ppooii.proyecto.entities.Persona;
import java.util.List;


public interface PersonaRepository extends JpaRepository<Persona, Serializable>, PagingAndSortingRepository<Persona, Serializable> {
    
    public abstract Persona findById(int id);
    public abstract Persona findByIdentificacion(int identificacion); // *
    public abstract List<Persona> findByEdad(int edad); // SI
    public abstract List<Persona> findByPApellido(String papellido); // *
    public abstract List<Persona> findByPNombre(String pombre); // SI

}
