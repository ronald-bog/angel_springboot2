package com.universidad.ppooii.apirest.services.interfaces;

import com.universidad.ppooii.apirest.entities.Persona;
//import org.springframework.data.domain.Pageable;


import java.util.List;


public interface IPersonaService {


    // Métodos CRUD
    public void guardar(Persona persona);
    public List<Persona> consultarPersona();
    public void actualizar(long id, Persona persona);
    public void eliminar(long id);

    // Búsquedas Específicas
    public Persona findByidentificacion(long identificacion);
    public List<Persona> findByedad(int edad);

    public List<Persona> findBypapellido(String papellido);
    public List<Persona> findBypnombre(String p_nombre);

}
