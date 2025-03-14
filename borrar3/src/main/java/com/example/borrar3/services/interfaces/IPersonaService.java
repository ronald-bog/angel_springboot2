package com.example.borrar3.services.interfaces;

import com.example.borrar3.model.Persona;

import java.util.List;

public interface IPersonaService {

    public void create(Persona persona);
    public List<Persona> read(Persona persona);
    public void update(Long id, Persona persona);
    public void delete(Long id);

    //public List<Persona> findBypnombre(String pnombre);
}
