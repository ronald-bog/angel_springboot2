package com.universidad.ppooii.apirest.controllers;

import com.universidad.ppooii.apirest.entities.Persona;
//import com.universidad.ppooii.apirest.repositories.PersonaRepository;
import com.universidad.ppooii.apirest.services.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Proyecto")
public class PersonaController {

    @Autowired
    //private PersonaRepository personaRepository;
    private PersonaServiceImpl personaServiceImpl;

    // Métodos CRUD
    @PostMapping("/persona")
    public void agregarPersona(@RequestBody Persona persona){
        personaServiceImpl.guardar(persona);
    }

    @GetMapping("/personas")
    public List<Persona> listadoPersona(){
        return personaServiceImpl.consultarPersona();
    }

    @PutMapping("/persona/{id}")
    public void editarPersona(@PathVariable long id, @RequestBody Persona persona){
        personaServiceImpl.actualizar(id, persona);
    }

    @DeleteMapping("/persona/{id}")
    public void eliminarPersona(@PathVariable long id){
        personaServiceImpl.eliminar(id);
    }

    // Búsquedas Específicas
    @GetMapping("/persona/identificacion/{identificacion}")
    public Persona getByidentificacion(@PathVariable long identificacion){
        return personaServiceImpl.findByidentificacion(identificacion);
    }

    @GetMapping("/persona/edad/{edad}")
    public List<Persona> getByedad(@PathVariable int edad){
        return personaServiceImpl.findByedad(edad);
    }

    @GetMapping("/persona/papellido/{papellido}")
    public List<Persona> getBypapellido(@PathVariable String papellido){
        return personaServiceImpl.findBypapellido(papellido);
    }

    @GetMapping("/persona/pnombre/{pnombre}")
    public List<Persona> getBypnombre(@PathVariable String pnombre){
        return personaServiceImpl.findBypnombre(pnombre);
    }
}
