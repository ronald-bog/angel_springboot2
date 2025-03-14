package com.universidad.ppooii.apirest.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long identificacion;
    private String pnombre;
    private String snombre;
    private String papellido;
    private String sapellido;
    private String email;
    private Date fechanacimiento;
    private int edad;
    private String edadclinica;

}
