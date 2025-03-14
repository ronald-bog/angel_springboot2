package com.ppooii.proyecto.Services.Interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ppooii.proyecto.entities.Persona;

public interface IPersonaService {

    // METODOS CRUD
    public boolean guardar(Persona persona);
    public boolean actualizar(Persona persona);
    public boolean eliminar(int id);
    public List<Persona> consultarPersona(Pageable pageable);

    // LISTA DE PERSONA POR ID
    public Persona findById(int id);
    // LISTA DE PERSONA POR NUMERO DE IDENTIFICACIÓN
    public Persona findByIdentificacion(int identificacion);
    // LISTA DE PERSONA POR EDAD
    public List<Persona> findByEdad(int edad);
    //LISTA DE PERSONA POR PRIMER NOMBRE
    public List<Persona> findByNombre(String pnombre);
    // LISTA DE PERSONA POR PRIMER APELLIDO
    public List<Persona> findByApellido(String papellido);

}
