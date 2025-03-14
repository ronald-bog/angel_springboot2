package com.ppooii.proyecto.Services;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ppooii.proyecto.Services.Interfaces.IPersonaService;
import com.ppooii.proyecto.entities.Persona;
import com.ppooii.proyecto.repository.PersonaRepository;

@Service("PersonaService")
public class PersonaServiceImpl implements IPersonaService{

    // ================== INYECCION DE DEPENDENCIAS =========================
	@Autowired
	@Qualifier("IPersonaRepo")
	private PersonaRepository IPersonaRepository;
	// ================= LOGS =====================================
	// LOGS DE ERROR
	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(PersonaServiceImpl.class);
	// INSERT
	@Override
	public boolean guardar(Persona persona) {
		try {
			if(persona == null) {
				logger.error("ERROR AGREGAR_PERSONA: LA PERSONA ES NULO!");
				return false;
			} else {
				IPersonaRepository.save(persona);
				return true;
			}
		}catch(Exception e) {
			logger.error("ERROR AGREGAR_PERSONA: LA PERSONA NO SE HA GUARDADO!");
			return false;
		}
	}
	// UPDATE
	@Override
	public boolean actualizar(Persona persona) {
		try {
			if( (persona == null) || (persona.getId() == 0) ) {
				logger.error("ERROR EDITAR_PERSONA: LA PERSONA ES NULO O EL ID ES 0!");
				return false;
			}else {
				IPersonaRepository.save(persona);
				return true;
			}
		}catch(Exception e) {
			logger.error("ERROR EDITAR_PERSONA: LA PERSONA NO SE HA EDITADO!");
			return false;
		}
	}
	// DELETE
	@Override
	public boolean eliminar(int id) {
		try {
			if( (id == 0) ) {
				logger.error("ERROR ELIMINAR_PERSONA: EL ID DE LA PERSONA ES 0!");
				return false;
			} else {
				Persona persona = IPersonaRepository.findById(id);
				IPersonaRepository.delete(persona);
				return true;
			}
		}catch(Exception e){
			logger.error("ERROR ELIMINAR_PERSONA: LA PERSONA NO SE HA ELIMINADO!");
			return false;
		}
	}

	// LISTA DE PERSONAS
	@Override
	public List<Persona> consultarPersona(Pageable pageable){
		return IPersonaRepository.findAll(pageable).getContent();
	}
	
	// ======= METODOS DE BUSQUEDA ==============

	// PERSONA POR ID| VALOR UNICO
	@Override
	public Persona findById(int id) {
		return IPersonaRepository.findById(id);
	}

	// PERSONA POR IDENTIFICACION | VALOR UNICO
	@Override
	public Persona findByIdentificacion(int identificacion) {
		return IPersonaRepository.findByIdentificacion(identificacion);
	}

    // LISTA DE PERSONAS POR EDAD
	@Override
	public List<Persona> findByEdad(int edad){
		return IPersonaRepository.findByEdad(edad);
	}
	
	// LISTA DE PERSONAS POR PRIMER NOMBRE
	@Override
	public List<Persona> findByNombre(String pnombre){
		return IPersonaRepository.findByPNombre(pnombre);
	}

    // LISTA DE PERSONAS POR PRIMER APELLIDO
    @Override
	public List<Persona> findByApellido(String papellido){
		return IPersonaRepository.findByPApellido(papellido);
	}


}