package com.ppooii.proyecto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ppooii.proyecto.entities.Usuario;
// import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>, PagingAndSortingRepository<Usuario, Serializable> {

}
