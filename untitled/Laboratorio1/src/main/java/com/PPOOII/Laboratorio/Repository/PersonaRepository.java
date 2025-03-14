package com.PPOOII.Laboratorio.Repository;

// import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.PPOOII.Laboratorio.Entities.Persona;

@Repository("IPersonaRepository")
public interface PersonaRepository extends JpaRepository<Persona, Integer>, CrudRepository<Persona, Integer>{

	public abstract Persona findById(int id);

	public abstract List<Persona> findByPnombre(String pnombre);

	public abstract List<Persona> findByEdad(int edad);

	public abstract Page<Persona> findAll(Pageable pageable);

}
