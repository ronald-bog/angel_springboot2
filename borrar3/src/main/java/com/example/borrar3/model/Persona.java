package com.example.borrar3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.Date;

@Entity
@Data
@Component
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long identificacion;
    private String pNombre;
    private String sNombre;
    private String pApellido;
    private String sApellido;
    private String email;
    private Date fechaNacimiento;
    private int edad;
    private String edadClinica;
}