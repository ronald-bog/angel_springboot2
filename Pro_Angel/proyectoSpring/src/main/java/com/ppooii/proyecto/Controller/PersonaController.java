package com.ppooii.proyecto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ppooii.proyecto.Services.PersonaServiceImpl;
import com.ppooii.proyecto.entities.Persona;

@RestController
//@RequestMapping("/ProyectoV1")
public class PersonaController {

    // ======= INYECCION DEL SERVICE =========
	@Autowired
	@Qualifier("PersonaService")
	PersonaServiceImpl personaService;

	@GetMapping()
	public String index() {
		return "HOLA MUNDO";
	}
	// ======= MÉTODOS HTTP =================
	// METODO POST 
	@PostMapping("/persona")
	public boolean agregarPersona(@RequestBody @Validated Persona persona) {
		return personaService.guardar(persona);
	}
	// METODO PUT
	@PutMapping("/persona")
	public boolean editarPersona(@RequestBody @Validated Persona persona) {
		return personaService.actualizar(persona);
	}
	// METODO DELETE
	@DeleteMapping("/persona/{id}")
	public boolean eliminarPersona(@PathVariable int id) {
		return personaService.eliminar(id);
	}
	// METODO GET
	@GetMapping("/personas")
	public List<Persona> listadoPersona(Pageable pageable){
		return personaService.consultarPersona(pageable);
	}
	
	// ========= MÉTODOS HTTP DE BÚSQUEDA ========
		// ---GET---
	@GetMapping("/persona/id/{id}")
	public Persona getById(@PathVariable int id) {
		return personaService.findById(id);
	}
	// ---GET---
	@GetMapping("/persona/identificacion/{identificacion}")
	public Persona getByIdent(@PathVariable int identificacion) {
		return personaService.findByIdentificacion(identificacion);
	}
	// ---GET---
	@GetMapping("/persona/edad/{edad}")
	public List<Persona> getByEdad(@PathVariable int edad) {
		return personaService.findByEdad(edad);
	}

	// ---GET---
	@GetMapping("/persona/papellido/{papellido}")
	public List<Persona> getByPApellido(@PathVariable String papellido) {
		return personaService.findByApellido(papellido);
	}

	// ---GET---
	@GetMapping("/persona/pnombre/{pnombre}")
	public List<Persona> getByPNombre(@PathVariable String pnombre) {
		return personaService.findByNombre(pnombre);
	}

}
