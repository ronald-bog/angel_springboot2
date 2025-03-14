package com.example.borrar3.services;

import com.example.borrar3.model.Persona;
import com.example.borrar3.repository.Repository;
import com.example.borrar3.services.interfaces.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    private Repository repo;

    @Autowired
    private Persona persona;

//    public List<Persona> findByPnombre(String pnombre) {
//        System.out.println(repo.findBypnombre(pnombre));
//        return repo.findBypnombre(pnombre);
//    }

    @Override
    public void create(Persona persona) {
        repo.save(persona);
    }

    @Override
    public List<Persona> read(Persona persona) {
        return repo.findAll();
    }

    @Override
    public void update(Long id, Persona persona) {
        Persona per = repo.findById(id).get();
        per.setIdentificacion(persona.getIdentificacion());
        per.setPNombre(persona.getPNombre());
        per.setSNombre(persona.getSNombre());
        per.setPApellido(persona.getPApellido());
        per.setSApellido(persona.getSApellido());
        per.setEmail(persona.getEmail());
        per.setFechaNacimiento(persona.getFechaNacimiento());
        per.setEdad(persona.getEdad());
        per.setEdadClinica(persona.getEdadClinica());
        repo.save(per);
    }

    @Override
    public void delete(Long id) {
        Persona per = repo.findById(id).get();
        repo.delete(per);
    }
}
