package com.ppooii.proyecto.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Persona", schema = "PPOOII_PF")
public class Persona implements Serializable {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getpNombre() {
        return pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEdadClinica() {
        return edadClinica;
    }

    public void setEdadClinica(String edadClinica) {
        this.edadClinica = edadClinica;
    }

//    @PrePersist
//    public void calculateAge() {
//        LocalDate currentDate = LocalDate.now();
//        Period period = Period.between(fechaNacimiento, currentDate);
//        this.edad = period.getYears();
//        this.edadClinica = period.getYears() + " años " + period.getMonths() + " meses " + period.getDays() + " días";
//    }

//    @PrePersist
//    public void generarLogin() {
//        String valorCompletoPnombre = this.pNombre;
//        String primeraLetraPapellido = this.pApellido.substring(0, 1);
//        String valorCompletoCampoId = String.valueOf(this.id);
//
//        this.login = valorCompletoPnombre + primeraLetraPapellido + valorCompletoCampoId;
//    }

    public Persona() {
    }

    public Persona(Long id, String login, int identificacion, String pNombre, String sNombre, String pApellido,
                   String sApellido, String email, LocalDate fechaNacimiento, int edad, String edadClinica) {
        this.id = id;
        this.login = login;
        this.identificacion = identificacion;
        this.pNombre = pNombre;
        this.sNombre = sNombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.edadClinica = edadClinica;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "identificacion", nullable = false)
    private int identificacion;

    @Column(name = "pNombre", nullable = false)
    private String pNombre;

    @Column(name = "sNombre")
    private String sNombre;

    @Column(name = "pApellido", nullable = false)
    private String pApellido;

    @Column(name = "sApellido")
    private String sApellido;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Transient
    private int edad;

    @Transient
    private String edadClinica;

}
