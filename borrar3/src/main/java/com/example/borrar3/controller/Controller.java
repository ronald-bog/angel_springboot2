package com.example.borrar3.controller;

import com.example.borrar3.model.Persona;
import com.example.borrar3.repository.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

//    @Autowired
//    //@Qualifier("PersonaService")
//    PersonaServiceImpl PersonaService;
    @Autowired
    //@Qualifier("Repo")
    private Repository repo;

//    @Autowired
//    private Persona per;
    //Persona persona = new Persona();

    @GetMapping()
    public String index() {
        return "Hola Mundo";
    }

    @GetMapping("read")
    public List<Persona> index2() {
        return repo.findAll();
    }

    @PostMapping("create")
    public Persona create(@RequestBody Persona persona) {
        return repo.save(persona);
    }

    @PutMapping("update/{id}")
    public String edit(@PathVariable Long id, @RequestBody Persona persona) {
        Persona per = repo.findById(id).get();
//        per.setNombre(persona.getNombre());
//        per.setTel(persona.getTel());
        repo.save(per);
        return "editado";
    }

    @DeleteMapping("delete/{id}")
    public String edit(@PathVariable Long id) {
        Persona per = repo.findById(id).get();
        repo.delete(per);
        return "editado";
    }

//    @GetMapping("/persona/pnombre/{pnombre}")
//    public List<Persona> getByNombre(@PathVariable("pnombre") String pnombre) {
//        return PersonaService.findBypnombre(pnombre);
//    }

}
