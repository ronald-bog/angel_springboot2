package com.example.borrar3.repository;

import com.example.borrar3.model.Persona;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

//@Qualifier("Repo")
public interface Repository extends JpaRepository<Persona, Long>, PagingAndSortingRepository<Persona, Long> {

    //public abstract List<Persona> findBypnombre(String pnombre);
}
